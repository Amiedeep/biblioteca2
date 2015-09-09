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
    public void shouldReturnMeNotAvailableWhenIPassNullToCheckOutBookMethod() {
        library = new Library();

        assertEquals("That book is not available", library.checkOutBook(null));
    }

    @Test
    public void shouldReturnMeNotAvailableWhenIPassSomeOtherBookNameToCheckOutBookMethod() {
        library = new Library();

        assertEquals("That book is not available", library.checkOutBook("some non-existing book"));
    }

    @Test
    public void shouldReturnMeAvailableWhenIPassExistingBookNameToCheckOutBookMethod() {
        library = new Library();

        assertEquals("Thank You! Enjoy the book", library.checkOutBook("scjp"));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassNullToReturnBookMethod() {
        library = new Library();

        assertEquals(false, library.returnBook(null));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassSomeOtherBookNameToReturnBookMethod() {
        library = new Library();

        assertEquals(false, library.returnBook("some non-existing book"));
    }
}