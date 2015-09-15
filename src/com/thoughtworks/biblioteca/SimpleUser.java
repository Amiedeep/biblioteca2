//A simple user class
package com.thoughtworks.biblioteca;

public class SimpleUser implements User {

    private String userName;
    private String password;

    public SimpleUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean logIn(String userName, String password) {
        return false;
    }
}
