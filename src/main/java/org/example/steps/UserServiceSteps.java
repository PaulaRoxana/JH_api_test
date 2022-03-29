package org.example.steps;

import org.example.entities.User;
import org.example.service.UserService;

import java.util.List;

import static org.example.service.uritemplate.UserServiceUri.USERS;
import static org.example.service.uritemplate.UserServiceUri.USER_BY_ID;

public class UserServiceSteps {
    private static final UserService USER_SERVICE = UserService.getInstance();

    public static List<User> getAllUsers() {
        return USER_SERVICE.getRequest(USERS).jsonPath().getList("", User.class);
    }

    public static User getUsersById(int id) {
        return USER_SERVICE.getRequest(USER_BY_ID, id).as(User.class);
    }

    public static User createUser(User user) {
        return USER_SERVICE.postRequest(USERS, user).as(User.class);
    }

    public static void deleteUserById(int id) {
        USER_SERVICE.deleteRequest(USER_BY_ID, id);
    }
}
