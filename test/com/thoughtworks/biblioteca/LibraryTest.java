package com.thoughtworks.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LibraryTest {

    private Library library;

    @Test
    public void shouldShowListOfBooksInFormattedOrder() {
        library = new Library();

        String expected ="List of books we have is: \n" +
                "scjp                                     kathy sierra                             1990                                    \n"+
                "head first java                          someone                                  2014                                    \n";
        assertEquals(expected, library.listBooks());
    }
}