package edu.hm.shareit.auth.storage;

import edu.hm.shareit.auth.model.User;

import java.util.LinkedList;
import java.util.List;

/**
 * UserStorage.
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @author Andrea Limmer, limmer@hm.edu
 * @since 18.05.17
 */
public class UserStorage {

    private static final UserStorage INSTANCE = new UserStorage();

    /**
     * Get the default UserStorage.
     * @return UserStorage.
     */
    public static UserStorage getDefault() {
        return INSTANCE;
    }

    private final List<User> users;

    /**
     * Constructor.
     */
    public UserStorage() {
        this.users = new LinkedList<>();
        users.add(new User("bob", "42"));
    }

    /**
     * Add user.
     * @param user User.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Check if contains user.
     * @param username Username.
     * @return true if contains username.
     */
    public boolean containsUser(String username) {
        return users.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    /**
     * Get the user.
     * @param username Username to identify user.
     * @return User or null.
     */
    public User getUser(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    /**
     * Remove user.
     * @param username Username.
     * @return true if user was removed.
     */
    public boolean removeUser(String username) {
        return users.removeIf(u -> u.getUsername().equals(username));
    }
}
