package edu.hm.shareit.auth.model;

import java.util.Objects;

/**
 * The User.
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @author Andrea Limmer, limmer@hm.edu
 * @since 18.05.17
 */
public class User {

    private final String username;
    private final String password;

    /**
     * Constructor.
     */
    public User() {
        this("", "");
    }

    /**
     * Constructor.
     * @param username Username.
     * @param password Password.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter for the username.
     * @return username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for the password.
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username) 
            && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
