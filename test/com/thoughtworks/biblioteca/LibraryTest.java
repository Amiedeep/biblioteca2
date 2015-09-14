package com.thoughtworks.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LibraryTest {

    private Library library;

    @Test
    public void shouldShowListOfBooksInFormattedOrder() {
        library = new Library();

        String expected ="List of books we have is: \n" +
                         "Name                                     Author                                   Year Published                          \n" +
                         "------------------------------------------------------------------------------------------------\n" +
                         "scjp                                     kathy sierra                             1990                                    \n"+
                         "head first java                          someone                                  2014                                    \n";
        assertEquals(expected, library.listBooks());
    }

    @Test
    public void shouldShowListOfMoviesInFormattedOrder() {
        library = new Library();

        String expected ="List of movies we have is: \n" +
                         "Name                                     Year                                     Director                                 Rating                                  \n" +
                         "---------------------------------------------------------------------------------------------------------------------------------\n" +
                         "sholay                                   1981                                     Shakti kapoor                            10                                      \n" +
                         "sehansha                                 1990                                     Sunny deol                               9                                       \n"+
                         "3 idiots                                 2010                                     Amandeep Singh                           10                                      \n";
        assertEquals(expected, library.listMovies());
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

        assertEquals("This is not a valid book to return", library.returnBook(null));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassSomeOtherBookNameToReturnBookMethod() {
        library = new Library();

        assertEquals("This is not a valid book to return", library.returnBook("some non-existing book"));
    }

    @Test
    public void shouldReturnMeTrueWhenIPassExistingBookNameToReturnBookMethod() {
        library = new Library();

        assertEquals("Thank you for returning the book", library.returnBook("Do rajya"));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassNullTocCheckOutMovieMethod() {
        library = new Library();

        assertEquals(false, library.checkOutMovie(null));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassSomeOtherMovieNameToCheckOutMovieMethod() {
        library = new Library();

        assertEquals(false, library.checkOutMovie("some non-sense"));
    }
}