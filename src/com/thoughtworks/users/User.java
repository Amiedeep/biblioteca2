//A user interface with some behaviour.
package com.thoughtworks.users;

public interface User {

    boolean logIn(String libraryNumber, String password);

    String userInfo();

    String userInfoToDisplay();

    String getUserHeaders();
}
