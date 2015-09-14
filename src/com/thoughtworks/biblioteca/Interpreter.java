//It takes the input, Interpret it.
package com.thoughtworks.biblioteca;

public class Interpreter {

    private Library library;
    private ConsoleInput consoleInput;

    public Interpreter(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    public void interpret(String input) {
        Display invalidOption = new Display("Select a valid option!");
        switch (input) {
            case "1":
                displayAllBooks();
                break;
            case "2":
                checkOutBook();
                break;
            case "3":
                System.exit(0);
            case "4":
                returnBook();
                break;
            case "5":
                displayAllMovies();
                break;
            case "6":
                checkOutMovie();
                break;
            default:
                invalidOption.display();
        }
    }

    private void checkOutMovie() {
        new Display("Enter movie name to checkout").display();
        String movieName = consoleInput.getInput();
        library.checkOutMovie(movieName);
    }

    private void displayAllMovies() {
        String movieList = library.listMovies();
        new Display(movieList).display();
    }

    private void returnBook() {
        new Display("Enter book name to return").display();
        String bookName = consoleInput.getInput();
        String returnMessage = library.returnBook(bookName);
        new Display(returnMessage).display();
    }

    private void checkOutBook() {
        new Display("Enter book name to checkout").display();
        String bookName = consoleInput.getInput();
        String checkOutBookMessage = library.checkOutBook(bookName);
        new Display(checkOutBookMessage).display();
    }

    private void displayAllBooks() {
        String bookList = library.listBooks();
        new Display(bookList).display();
    }
}
