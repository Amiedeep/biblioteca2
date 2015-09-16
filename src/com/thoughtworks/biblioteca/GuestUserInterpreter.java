package com.thoughtworks.biblioteca;

public class GuestUserInterpreter extends Interpreter {

    public GuestUserInterpreter(Library library, ConsoleInput consoleInput) {
        super(library, consoleInput);
    }

    public void interpret(String input) {
        Display invalidOption = new Display("Select a valid option!");
        switch (input) {
            case "1":
                displayAllBooks();
                break;
            case "2":
                displayAllMovies();
                break;
            case "3":
                checkOutMovie();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                invalidOption.display();
        }
    }
}
