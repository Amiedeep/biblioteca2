package com.thoughtworks.interpreters;

import com.thoughtworks.Operations.*;
import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;

public class LibrarianUserInterpreter implements Interpreter {

    private Library library;
    private ConsoleInput consoleInput;

    public LibrarianUserInterpreter(Library library, ConsoleInput consoleInput) {
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
                return new CheckOutBookOperation(library, consoleInput);
            case "5":
                return new ReturnBookOperation(library, consoleInput);
            case "6":
                return new CheckedOutBooksStatusOperation(library);
            case "7":
                return new ExitOperation();
            case "8":
                return new LogOutOperation();
            case "9":
                return new UserInfoOperation(library);
            default:
                return new InvalidOperation();
        }
    }
}
