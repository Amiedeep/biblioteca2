//It takes the input, Interpret it.
package com.thoughtworks.interpreters;

import com.thoughtworks.Operations.*;
import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;

public class SimpleUserInterpreter implements Interpreter {

    private Library library;
    private ConsoleInput consoleInput;

    public SimpleUserInterpreter(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    public Operation interpret(String input) {
        switch (input) {
            case "1":
                return new ListBooksOperation(library);
            case "2":
                return new CheckOutBookOperation(library, consoleInput);
            case "3":
                return new ExitOperation();
            case "4":
                return new ReturnBookOperation(library, consoleInput);
            case "5":
                return new ListMoviesOperation(library);
            case "6":
                return new CheckOutMovieOperation(library, consoleInput);
            case "7":
                return new LogOutOperation();
            default:
                return new InvalidOperation();
        }
    }
}
