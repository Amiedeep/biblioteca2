package com.thoughtworks.options;

import java.util.Arrays;

public class LibrarianOptions extends Options {

    public LibrarianOptions() {
        super(Arrays.asList("List Books", "List Movies", "checkout movie", "Checkout book", "Return book", "Books status", "Quit", "logout"));
    }
}
