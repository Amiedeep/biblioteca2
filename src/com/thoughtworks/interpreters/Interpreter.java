package com.thoughtworks.interpreters;

import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;

public abstract class Interpreter {

    private Library library;
    private ConsoleInput consoleInput;

    public Interpreter(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    public void checkOutMovie() {
        new Display("Enter movie name to checkout").display();
        String movieName = consoleInput.getInput();
        library.checkOutMovie(movieName);
    }

    public void displayAllMovies() {
        String movieList = library.listMovies();
        new Display(movieList).display();
    }

    public void returnBook() {
        new Display("Enter book name to return").display();
        String bookName = consoleInput.getInput();
        String returnMessage = library.returnBook(bookName);
        new Display(returnMessage).display();
    }

    public void checkOutBook() {
        new Display("Enter book name to checkout").display();
        String bookName = consoleInput.getInput();
        String checkOutBookMessage = library.checkOutBook(bookName);
        new Display(checkOutBookMessage).display();
    }

    public void displayAllBooks() {
        String bookList = library.listBooks();
        new Display(bookList).display();
    }

    public abstract void interpret(String input);
}
