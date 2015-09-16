package com.thoughtworks.users;

import com.thoughtworks.biblioteca.Book;

public class GuestUser implements User{

    @Override
    public boolean logIn(String thatUserName, String thatPassword) {
        return true;
    }

    @Override
    public String getCheckedOutBooksInfo() {
        return null;
    }

    @Override
    public void addToCheckoutBooks(Book book) {

    }
}
