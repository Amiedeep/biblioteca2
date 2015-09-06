//This class starts the biblioteca application.
package com.thoughtworks.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApplication {

    private final List<Book> listOfBooks = Arrays.asList(new Book("scjp", "kathy sierra", 1990), new Book("head first java", "someone", 2014));
    private DisplayConsole displayConsole;

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start("Hey! Welcome to biblioteca");
    }

    public void start(String welcomeMessage) {
        printWelcomeMessage(welcomeMessage);
        printBooks();
    }

    private void printWelcomeMessage(String welcomeMessage) {
        displayConsole = new DisplayConsole(welcomeMessage);
        displayConsole.display();
    }

    private void printBooks() {
        String bookList = "List of books we have is: \n";
        for(Book book : listOfBooks) {
            bookList += book.toString();
        }
        displayConsole = new DisplayConsole(bookList);
        displayConsole.display();
    }
}
