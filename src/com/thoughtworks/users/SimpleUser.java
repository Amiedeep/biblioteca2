//A simple user class
package com.thoughtworks.users;

public class SimpleUser implements User {

    private String userName;
    private String password;

    public SimpleUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean logIn(String thatUserName, String thatPassword) {
        return userName.equals(thatUserName) && password.equals(thatPassword);
    }
}
