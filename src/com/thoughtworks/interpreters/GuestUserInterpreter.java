//This is interpreter against guest user
package com.thoughtworks.interpreters;

import com.thoughtworks.Operations.*;
import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;

public class GuestUserInterpreter implements Interpreter {

    private Library library;
    private ConsoleInput consoleInput;

    public GuestUserInterpreter(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    public Operation interpret(String input) {
        switch (input) {
            case "1":
                return new ListBooksOperation(library);
            case "2":
                return new ListMoviesOperation(library);
            case "3":
                return new CheckOutMovieOperation(library, consoleInput);
            case "4":
                return new ExitOperation();
            case "5":
                return new LogOutOperation();
            default:
                return new InvalidOperation();
        }
    }
}
