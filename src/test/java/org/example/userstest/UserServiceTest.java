package org.example.userstest;


import org.example.entities.User;
import org.example.steps.UserServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class UserServiceTest {


    @Test
    public void getAllUsersTest() {
        List<User> users = UserServiceSteps.getAllUsers();
        Assert.assertEquals(users.size(), 10, "Expected not equal to actual");
    }

    @Test
    public void createUserTest() {
        User expectedUser = createUser();
        User actualUser = UserServiceSteps.createUser(expectedUser);
        Assert.assertEquals(actualUser.getName(), expectedUser.getName(), "Expected user does not have the expected name");
    }

    private User createUser() {
        Random random = new Random();
        return new User()
                .setName("test" + random.nextInt())
                .setEmail("testEmail" + random.nextInt() + "@gmail.com")
                .setGender("Male")
                .setStatus("active");
    }
}
