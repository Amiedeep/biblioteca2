//When user provide librarian credentials this user is selected
package com.thoughtworks.users;

public class LibrarianUser implements User {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private Long phoneNumber;

    public LibrarianUser(String libraryNumber, String password, String name, String email, Long phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean logIn(String thatlibraryNumber, String thatPassword) {
        return libraryNumber.equals(thatlibraryNumber) && password.equals(thatPassword);
    }

    @Override
    public String userInfo() {
        return libraryNumber;
    }

    @Override
    public String userInfoToDisplay() {
        return String.format("%-40s %-40s %-40s %-40s\n", libraryNumber, name, email, phoneNumber);
    }
}
