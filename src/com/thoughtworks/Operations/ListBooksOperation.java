//This operation ask library to display all the available books in it.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;

public class ListBooksOperation implements Operation{

    private Library library;

    public ListBooksOperation(Library library) {
        this.library = library;
    }

    @Override
    public void executeOperation() {
        String bookList = library.listBooks();
        new Display(bookList).display();
    }
}
