//It will display all the checked out books status in formatted way.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;

public class CheckedOutBooksStatusOperation implements Operation {

    private Library library;

    public CheckedOutBooksStatusOperation(Library library) {
        this.library = library;
    }

    @Override
    public void executeOperation() {
        String checkedOutInfo = library.checkedOutBooksStatus();
        new Display(checkedOutInfo).display();
    }
}
