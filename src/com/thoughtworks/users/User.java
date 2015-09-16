//A user interface with some behaviour.
package com.thoughtworks.users;

public interface User {

    boolean logIn(String userName, String password);

    String userInfo();
}
