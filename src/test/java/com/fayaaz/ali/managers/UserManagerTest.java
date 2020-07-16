package com.fayaaz.ali.managers;

import com.fayaaz.ali.models.User;
import com.fayaaz.ali.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserManagerTest {
    @Test
    public void shouldReturnInstanceOfUserManager() {
        UserManager userManager = new UserManager(null);
        Assert.assertNotNull(userManager);
    }

    @Test
    public void showReturnListOfUser() {
        UserService userServiceMock = mock(UserService.class);
        when(userServiceMock.getAllUsers()).thenReturn(Arrays.asList(
                new User("Fayaaz","Ali",29),
                new User("Liam","Håkansson",26),
                new User("Eva","Böralv",28),
                new User("Team","Nardo",100)));
        UserManager userManager = new UserManager(userServiceMock);
        List<User> results = userManager.getAllUsers();
        Assert.assertNotNull(results);
        Assert.assertEquals(4,results.size());
        verify(userServiceMock, Mockito.times(1)).getAllUsers();
    }
}
