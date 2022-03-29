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
        Assert.assertEquals(users.size(), 20, "Expected users list size doesn't equal to actual");
    }

    @Test
    public void getUsersByIdTest() {
        List<User> users = UserServiceSteps.getAllUsers();

        User user = UserServiceSteps.getUsersById(users.get(0).getId());
        Assert.assertEquals(user.getName(), users.get(0).getName(), "Expected user doesn't have correct name");
    }

    @Test
    public void createUsersTest() {
        User expectedUser = createUser();
        User createdUser = UserServiceSteps.createUser(expectedUser);
        Assert.assertEquals(createdUser.getName(), expectedUser.getName(), "Expected user doesn't have correct name");
    }

    @Test
    public void deleteUsersTest() {
        User createdUser = UserServiceSteps.createUser(createUser());

        UserServiceSteps.deleteUserById(createdUser.getId());
        List<User> users = UserServiceSteps.getAllUsers();
        Assert.assertFalse(users.contains(createdUser), "Expected users list doesn't contain deleted element");
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
