package com.thoughtworks.biblioteca;

import java.util.Arrays;

public class GuestUserOptions extends Options {

    public GuestUserOptions() {
        super(Arrays.asList("List Books", "List Movies", "checkout movie", "quit"));
    }
}
