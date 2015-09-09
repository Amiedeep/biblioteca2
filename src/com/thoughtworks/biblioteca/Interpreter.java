//It takes the input, Interpret it and return the display.
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
        try {
            int option = Integer.parseInt(input);
            String bookName;
            String returnMessage;
            switch (option) {
                case 1:
                    String bookList = library.listBooks();
                    new Display(bookList).display();
                    break;
                case 2:
                    new Display("Enter book name to checkout").display();
                    bookName = consoleInput.getInput();
                    returnMessage = library.checkOutBook(bookName);
                    new Display(returnMessage).display();
                    break;
                case 3:
                    System.exit(0);
                case 4:
                    new Display("Enter book name to return").display();
                    bookName = consoleInput.getInput();
                    returnMessage = library.returnBook(bookName);
                    new Display(returnMessage).display();
                    break;
                default:
                    invalidOption.display();
            }
        } catch (NumberFormatException e) {
            invalidOption.display();
        }
    }
}
