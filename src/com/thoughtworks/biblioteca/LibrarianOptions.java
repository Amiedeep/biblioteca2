package com.thoughtworks.biblioteca;

import java.util.Arrays;

public class LibrarianOptions extends Options {

    public LibrarianOptions() {
        super(Arrays.asList("List Books", "Checkout book", "Quit", "Return book", "List Movies", "checkout movie", "Books status"));
    }
}
