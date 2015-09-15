package com.thoughtworks.biblioteca;

public class GuestUser implements User{

    @Override
    public boolean logIn(String thatUserName, String thatPassword) {
        return true;
    }
}
