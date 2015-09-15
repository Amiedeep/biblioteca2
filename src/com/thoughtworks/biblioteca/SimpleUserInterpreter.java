//It takes the input, Interpret it.
package com.thoughtworks.biblioteca;

public class SimpleUserInterpreter extends Interpreter {

    public SimpleUserInterpreter(Library library, ConsoleInput consoleInput) {
        super(library, consoleInput);
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
}
