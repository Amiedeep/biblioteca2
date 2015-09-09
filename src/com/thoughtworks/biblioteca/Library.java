//Library contains books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Book> listOfBooks = new ArrayList<>(Arrays.asList(new Book("scjp", "kathy sierra", 1990),
                                                         new Book("head first java", "someone", 2014)));
    private List<Book> checkedOutBooks = new ArrayList<>();

    public String listBooks() {
        String bookList = "List of books we have is: \n";
        for(Book book : listOfBooks) {
            bookList += book.toString();
        }
        return bookList;
    }

    public String checkOutBook(String bookName) {
        for(Book book : listOfBooks) {
            if(book.compareBookNameWith(bookName)) {
                checkOutBook(book);
                return "Thank You! Enjoy the book";
            }
        }
        return "That book is not available";
    }

    private void checkOutBook(Book book) {
        listOfBooks.remove(book);
        checkedOutBooks.add(book);
    }
}
