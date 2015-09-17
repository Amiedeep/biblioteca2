//This operation ask library to check out movie present in it.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;

public class CheckOutMovieOperation implements Operation{

    private Library library;
    private ConsoleInput consoleInput;

    public CheckOutMovieOperation(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    @Override
    public void executeOperation() {
        new Display("Enter movie name to checkout").display();
        String movieName = consoleInput.getInput();
        library.checkOutMovie(movieName);
    }
}
