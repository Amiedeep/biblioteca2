package com.thoughtworks.interpreters;

import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;

public class LibrarianUserInterpreter extends Interpreter {

    public LibrarianUserInterpreter(Library library, ConsoleInput consoleInput) {
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
                checkOutBook();
                break;
            case "5":
                returnBook();
                break;
            case "7":
                System.exit(0);
                break;
            default:
                invalidOption.display();
        }
    }
}
