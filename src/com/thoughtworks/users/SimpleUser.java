//When user provide simple user credentials this user is selected
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

    @Override
    public String userInfo() {
        return userName;
    }
}
