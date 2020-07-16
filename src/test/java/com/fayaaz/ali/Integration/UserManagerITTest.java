package com.fayaaz.ali.Integration;

import com.fayaaz.ali.managers.UserManager;
import com.fayaaz.ali.models.User;
import com.fayaaz.ali.repository.UserRepositoryImpl;
import com.fayaaz.ali.services.BaseTest;
import com.fayaaz.ali.services.UserServiceimpl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserManagerITTest extends BaseTest {

    private static Connection connection;

    @BeforeClass
    public static void SetUpClass() throws SQLException {
        connection = getH2Connection();
        addTable(connection);
        insertData(connection);
    }

    @Test
    public void shouldReturnTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldReturnAnInstanceofUserManager() {
        UserManager userManager = new UserManager(null);
        Assert.assertNotNull(userManager);
    }

    @Test
    public void shouldReturnListOfAllUsersWhenGetAllUsersCalled() {
        UserManager userManager = new UserManager(new UserServiceimpl(new UserRepositoryImpl(connection)));
        List<User> results =userManager.getAllUsers();
        Assert.assertFalse(results.isEmpty());
        Assert.assertEquals(4,results.size());
    }

    @AfterClass
    public static void TearDownClass() throws SQLException {
        //dropTable(connection);
    }
}
