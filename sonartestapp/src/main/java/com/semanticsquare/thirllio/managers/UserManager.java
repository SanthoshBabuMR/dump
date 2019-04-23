package com.semanticsquare.thirllio.managers;

import com.semanticsquare.thrillio.dao.UserDao;
import com.semanticsquare.thrillio.entities.User;

// suffix with "Manager"; Same as "Service"
public class UserManager {

    // Singleton
    private static UserManager instance = new UserManager();
    private static UserDao dao = new UserDao();


    private UserManager() {
    }

    public static UserManager getInstance() {
        return instance;
    }

    public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
                           String userType) {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setUserType(userType);

        return user;
    }

    public User[] getUsers() {
        return dao.getUsers();
    }

}
