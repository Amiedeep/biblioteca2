//This operation ask library to display all the available movies in it.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;

public class ListMoviesOperation implements Operation{

    private Library library;

    public ListMoviesOperation(Library library) {
        this.library = library;
    }

    @Override
    public void executeOperation() {
        String movieList = library.listMovies();
        new Display(movieList).display();
    }
}
