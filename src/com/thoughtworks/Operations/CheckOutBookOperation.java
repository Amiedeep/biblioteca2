//This operation ask library to check out book present in it.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;

public class CheckOutBookOperation implements Operation{

    private Library library;
    private ConsoleInput consoleInput;

    public CheckOutBookOperation(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    @Override
    public void executeOperation() {
        new Display("Enter book name to checkout").display();
        String bookName = consoleInput.getInput();
        String checkOutBookMessage = library.checkOutBook(bookName);
        new Display(checkOutBookMessage).display();
    }
}
