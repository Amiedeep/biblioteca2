//When Customer chooses proceed as guest this user is selected.
package com.thoughtworks.users;

public class GuestUser implements User{

    @Override
    public boolean logIn(String thatUserName, String thatPassword) {
        return true;
    }

    @Override
    public String userInfo() {
        return null;
    }
}
