/*
 * Wolfgang Gabler
 *
 * Software: Mac OS X 10.12, Oracle Java 1.8.0_111 SE
 * System: Intel Core i7-4850HQ, 16 GByte RAM
 */
package edu.hm.shareit.auth.storage;

import edu.hm.shareit.auth.model.User;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @since 18.05.17
 */
public class UserStorage {

    private static final UserStorage INSTANCE = new UserStorage();

    public static UserStorage getDefault() {
        return INSTANCE;
    }

    private final List<User> users;

    public UserStorage() {
        this.users = new LinkedList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean containsUser(String username) {
        return users.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    public User getUser(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    public boolean removeUser(String username) {
        return users.removeIf(u -> u.getUsername().equals(username));
    }
}
