package com.semanticsquare.thrillio.dao;

import com.semanticsquare.thirllio.DataStore;
import com.semanticsquare.thrillio.entities.User;

public class UserDao {
    public User[] getUsers() {
        return DataStore.getUsers();
    }
}
