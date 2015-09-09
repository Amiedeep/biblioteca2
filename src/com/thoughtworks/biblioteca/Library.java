//Library contains books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Book> listOfBooks = new ArrayList<>(Arrays.asList(new Book("scjp", "kathy sierra", 1990),
                                                         new Book("head first java", "someone", 2014)));
    private List<Book> checkedOutBooks = new ArrayList<>(Arrays.asList(new Book("Do rajya", "chetan bhagat", 1767)));

    public String listBooks() {
        String bookList = "List of books we have is: \n";
        bookList = printHeaders(bookList);
        for(Book book : listOfBooks) {
            bookList += book.toString();
        }
        return bookList;
    }

    private String printHeaders(String bookList) {
        bookList += String.format("%-40s %-40s %-40s\n", "Name", "Author", "Year Published");
        for (int i = 0; i < 96; i++) {
            bookList += "-";
        }
        bookList += "\n";
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

    public String returnBook(String bookName) {
        for(Book book : checkedOutBooks) {
            if(book.compareBookNameWith(bookName)) {
                returnBook(book);
                return "Thank you for returning the book";
            }
        }
        return "This is not a valid book to return";
    }

    private void returnBook(Book book) {
        checkedOutBooks.remove(book);
        listOfBooks.add(book);
    }
}
