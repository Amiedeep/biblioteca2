//It takes the input, Interpret it and return the view.
package com.thoughtworks.biblioteca;

public class Interpreter {

    private Library library;
    private ConsoleInput consoleInput;

    public Interpreter(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    public void interpret(String input) {
        int option = Integer.parseInt(input);
        View invalidOption = new View("Select a valid option!");
        switch (option) {
            case 1:
                String bookList = library.listBooks();
                new View(bookList).display();
                break;
            case 2:
                new View("Enter book name to display").display();
                String bookName = consoleInput.getInput();
                library.checkOutBook(bookName);
                break;
            default:
                invalidOption.display();
        }
    }
}
