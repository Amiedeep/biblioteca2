//A user interface with behaviour login.
package com.thoughtworks.users;

import com.thoughtworks.biblioteca.Book;

import java.util.ArrayList;
import java.util.List;

public interface User {

    List<Book> checkedOutBooks = new ArrayList<>();

    boolean logIn(String userName, String password);

    String getCheckedOutBooksInfo();

    void addToCheckoutBooks(Book book);
}
