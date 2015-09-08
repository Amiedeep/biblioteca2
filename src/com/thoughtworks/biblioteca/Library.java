//Library contains books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Book> listOfBooks = Arrays.asList(new Book("scjp", "kathy sierra", 1990),
                                                         new Book("head first java", "someone", 2014));
    private List<Book> checkedOutBooks = new ArrayList<>();

    public String listBooks() {
        String bookList = "List of books we have is: \n";
        for(Book book : listOfBooks) {
            bookList += book.toString();
        }
        return bookList;
    }

    public boolean checkOutBook(String bookName) {
        return false;
    }

    private void checkOutBook(Book book) {
        listOfBooks.remove(book);
        checkedOutBooks.add(book);
    }
}
