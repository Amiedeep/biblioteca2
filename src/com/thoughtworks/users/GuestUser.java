package com.thoughtworks.users;


public class GuestUser implements User{

    @Override
    public boolean logIn(String thatUserName, String thatPassword) {
        return true;
    }
}
