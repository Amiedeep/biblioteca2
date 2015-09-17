//When user provide librarian credentials this user is selected
package com.thoughtworks.users;

public class LibrarianUser implements User {

    private String libraryNumber;
    private String password;

    public LibrarianUser(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean logIn(String thatlibraryNumber, String thatPassword) {
        return libraryNumber.equals(thatlibraryNumber) && password.equals(thatPassword);
    }

    @Override
    public String userInfo() {
        return libraryNumber;
    }
}
