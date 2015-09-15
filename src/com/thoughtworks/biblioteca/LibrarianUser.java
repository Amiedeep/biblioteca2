package com.thoughtworks.biblioteca;

public class LibrarianUser implements User {

    private String userName;
    private String password;

    public LibrarianUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean logIn(String thatUserName, String thatPassword) {
        return userName.equals(thatUserName) && password.equals(thatPassword);
    }
}
