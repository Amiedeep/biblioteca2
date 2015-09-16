package com.thoughtworks.options;

import java.util.Arrays;

public class SimpleUserOptions extends Options {

    public SimpleUserOptions() {
        super(Arrays.asList("List Books", "Checkout book", "Quit", "Return book", "List Movies", "checkout movie"));
    }
}
