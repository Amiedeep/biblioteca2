//This operation ask library to return book present in it.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;

public class ReturnBookOperation implements Operation {

    private Library library;
    private ConsoleInput consoleInput;

    public ReturnBookOperation(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    @Override
    public void executeOperation() {
        new Display("Enter book name to return").display();
        String bookName = consoleInput.getInput();
        String returnMessage = library.returnBook(bookName);
        new Display(returnMessage).display();
    }
}
