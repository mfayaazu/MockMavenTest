package com.fayaaz.ali.repositories;

import com.fayaaz.ali.models.User;
import com.fayaaz.ali.repository.UserRepositoryImpl;
import com.fayaaz.ali.services.BaseTest;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserRepositoriesTest extends BaseTest {
    private static Connection connection;
    private UserRepositoryImpl userRepository;

    @Before
    public void setUp() {

        userRepository = new UserRepositoryImpl(connection);
    }

    @BeforeClass
    public static void setupClass() throws SQLException {
        connection = getH2Connection();
        addTable(connection);
        insertData(connection);
    }



    @Test
    public void shouldReturnUserRepoImpl() {
        Assert.assertNotNull(userRepository);
    }

    @Test(expected = RuntimeException.class)
    public void shouldTestSpy() throws SQLException {
        connection.createStatement();
        Connection spy = spy(connection);
        when(spy.createStatement()).thenThrow(new RuntimeException("Error Calling Method"));
        spy.createStatement();
    }

    @Test(expected = RuntimeException.class)
    public void shouldTestSpySecondCall() throws SQLException {
        Connection spy = spy(connection);
        when(spy.createStatement()).thenReturn(connection.createStatement()).thenThrow(new RuntimeException("Second Call Throw Exception"));
        spy.createStatement();
        spy.createStatement();
    }

    @Test
    public void shouldReturnAllUser() {
        List<User> users = userRepository.getAllUsers();
        Assert.assertNotNull(users);
        Assert.assertNotNull(users.size());
    }

    @Test
    public void shouldReturnAllUserThenThrowSQLException() throws SQLException {
        Connection spy = spy(connection);
        when(spy.createStatement()).thenReturn(connection.createStatement()).thenThrow(SQLException.class);
        UserRepositoryImpl spyRepository = new UserRepositoryImpl(spy);
        List<User> users = spyRepository.getAllUsers();
        verify(spy, never()).getAutoCommit();
        Assert.assertNotNull(users);
        Assert.assertNotNull(users.size());
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
       // connection.createStatement().executeUpdate("DROP TABLE USERS");
        connection.close();
    }
}
