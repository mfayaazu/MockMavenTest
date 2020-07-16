package com.fayaaz.ali.services;

import com.fayaaz.ali.models.User;
import com.fayaaz.ali.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserRepository userRepositoryMock;
    private UserService userService;

    @Before
    public void setUp() {
        userRepositoryMock =mock(UserRepository.class);
        userService=new UserServiceimpl(userRepositoryMock);
        System.out.println("Setup...");
    }

    @Test
    public void ShouldReturnUserServiceImplementation() {
        Assert.assertNotNull(userService);
    }

    @Test
    public void shouldReturnListOfAllUsers() {
        List<User>  users =Arrays.asList(
                new User("Fayaaz","Ali",29),
                new User("Liam","Håkansson",26),
                new User("Eva","Böralv",28),
                new User("Team","Nardo",100));

        doReturn(users).when(userRepositoryMock).getAllUsers();
        List<User> results = userService.getAllUsers();
        System.out.println("Hello Nandu this is jenkins test");
        Assert.assertNotNull(results);
        Assert.assertEquals(4,results.size());

        verify(userRepositoryMock, atLeastOnce()).getAllUsers();
        verify(userRepositoryMock, atLeast(1)).getAllUsers();
        verify(userRepositoryMock, atMost(1)).getAllUsers();
    }

    @After
    public void tearDown() {
        userRepositoryMock= null;
        userService=null;
        System.out.println("TearDown...");
    }
}
