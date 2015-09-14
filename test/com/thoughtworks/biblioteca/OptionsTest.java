package com.thoughtworks.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class OptionsTest {

    private Options options;

    @Test
    public void shouldReturnOptionsWhenICallgetOptionsMethod() {
        options = new Options();

        assertEquals("Please choose one option: \n1: List Books\n2: Checkout book\n3: Quit\n4: Return book\n5: List Movies\n6: checkout movie\n", options.getOptions());
    }
}