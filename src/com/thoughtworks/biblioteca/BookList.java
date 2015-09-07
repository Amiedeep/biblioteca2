package com.thoughtworks.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BookList {

    private final List<Book> listOfBooks = Arrays.asList(new Book("scjp", "kathy sierra", 1990),
                                                         new Book("head first java", "someone", 2014));

    public String listBooks() {
        String bookList = "List of books we have is: \n";
        for(Book book : listOfBooks) {
            bookList += book.toString();
        }
        return bookList;
    }
}
