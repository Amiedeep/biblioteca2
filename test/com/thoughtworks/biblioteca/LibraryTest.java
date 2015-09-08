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

    @Test
    public void shouldReturnMeFalseWhenIPassNullToCheckOutBookMethod() {
        library = new Library();

        assertEquals(false, library.checkOutBook(null));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassSomeOtherBookNameToCheckOutBookMethod() {
        library = new Library();

        assertEquals(false, library.checkOutBook("some non-existing book"));
    }

    @Test
    public void shouldReturnMeTrueWhenIPassExistingBookNameToCheckOutBookMethod() {
        library = new Library();

        assertEquals(true, library.checkOutBook("scjp"));
    }
}