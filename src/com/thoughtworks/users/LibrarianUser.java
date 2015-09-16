//When user provide librarian credentials this user is selected
package com.thoughtworks.users;

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

    @Override
    public String userInfo() {
        return userName;
    }
}
