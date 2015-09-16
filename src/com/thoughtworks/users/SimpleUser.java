//A simple user class
package com.thoughtworks.users;

import com.thoughtworks.biblioteca.Book;

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
    public String getCheckedOutBooksInfo() {
        String checkedOutBookInfo = "";
        for(Book book : checkedOutBooks) {
            checkedOutBookInfo += userName+" holds "+book.bookInfo()+"\n";
        }
        return checkedOutBookInfo;
    }

    @Override
    public void addToCheckoutBooks(Book book) {
        checkedOutBooks.add(book);
    }
}
