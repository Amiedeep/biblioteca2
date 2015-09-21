package com.thoughtworks.biblioteca;

import com.thoughtworks.users.GuestUser;
import com.thoughtworks.users.LibrarianUser;
import com.thoughtworks.users.SimpleUser;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library(new GuestUser());
    }

    @Test
    public void shouldShowListOfBooksInFormattedOrder() {
        String expected ="List of books we have is: \n" +
                         "Name                                     Author                                   Year Published                          \n" +
                         "------------------------------------------------------------------------------------------------\n" +
                         "scjp                                     kathy sierra                             1990                                    \n"+
                         "head first java                          someone                                  2014                                    \n";
        assertEquals(expected, library.listBooks());
    }

    @Test
    public void shouldShowListOfMoviesInFormattedOrder() {
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
        assertEquals("That book is not available", library.checkOutBook(null));
    }

    @Test
    public void shouldReturnMeNotAvailableWhenIPassSomeOtherBookNameToCheckOutBookMethod() {
        assertEquals("That book is not available", library.checkOutBook("some non-existing book"));
    }

    @Test
    public void shouldReturnMeAvailableWhenIPassExistingBookNameToCheckOutBookMethod() {
        assertEquals("Thank You! Enjoy the book", library.checkOutBook("scjp"));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassNullToReturnBookMethod() {
        assertEquals("This is not a valid book to return", library.returnBook(null));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassSomeOtherBookNameToReturnBookMethod() {
        assertEquals("This is not a valid book to return", library.returnBook("some non-existing book"));
    }

    @Test
    public void shouldReturnMeTrueWhenIPassExistingBookNameToReturnBookMethod() {
        library.checkOutBook("scjp");
        assertEquals("Thank you for returning the book", library.returnBook("scjp"));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassNullTocCheckOutMovieMethod() {
        assertEquals(false, library.checkOutMovie(null));
    }

    @Test
    public void shouldReturnMeFalseWhenIPassSomeOtherMovieNameToCheckOutMovieMethod() {
        assertEquals(false, library.checkOutMovie("some non-sense"));
    }

    @Test
    public void shouldReturnMeTrueWhenIPassExistingMovieNameToCheckOutMovieMethod() {
        assertEquals(true, library.checkOutMovie("3 idiots"));
    }

    @Test
    public void shouldReturnMeNullWhenIPassNullAslibraryNumberAndPasswordToLogInUserMethod() {
        assertNull(library.logInUser(null, null));
    }

    @Test
    public void shouldReturnMeNullWhenIPassNullAsLibraryNumberToLogInUserMethod() {
        assertNull(library.logInUser(null, "some password"));
    }

    @Test
    public void shouldReturnMeNullWhenIPassNullAsPasswordToLogInUserMethod() {
        assertNull(library.logInUser("Some libraryNumber", null));
    }

    @Test
    public void shouldReturnMeNullWhenIPassInvalidLibraryNumberAndPasswordToLogInUserMethod() {
        assertNull(library.logInUser("Some invalid libraryNumber", "Some invalid password"));
    }

    @Test
    public void shouldReturnMeSimpleUserWhenIPassValidSimpleUserLibraryNumberAndPasswordToLogInUserMethod() {
        assertEquals(SimpleUser.class, library.logInUser("111-2222", "abcd").getClass());
    }

    @Test
    public void shouldReturnMeLibrarianUserWhenIPassValidLibrarianUserLibraryNumberAndPasswordToLogInUserMethod() {
        assertEquals(LibrarianUser.class, library.logInUser("222-1111", "dcba").getClass());
    }

    @Test
    public void shouldReturnMeEmptyStringWhenThereIsNoBookCheckedOutAndICallCheckedOutBooksStatusMethod() {
        assertEquals("", library.checkedOutBooksStatus());
    }

    @Test
    public void shouldReturnMeBookStatusInOneLineWhenThereIsOneBookCheckedOutAndICallCheckedOutBooksStatusMethod() {
        library = new Library(new SimpleUser("some user", "some password", "Amie Deep", "Aman@pathashala.com", 523743276527l));
        library.checkOutBook("scjp");
        assertEquals("scjp authored by kathy sierra published on 1990 is checked out by some user with name Amie Deep\n", library.checkedOutBooksStatus());
    }

    @Test
    public void shouldReturnMeBookStatusInDifferentLineWhenThereIsMoreThanOneBookCheckedOutAndICallCheckedOutBooksStatusMethod() {
        library = new Library(new SimpleUser("some user", "some password", "Amie Deep", "Aman@pathashala.com", 523743276527l));
        library.checkOutBook("scjp");
        library.checkOutBook("head first java");
        String expected = "scjp authored by kathy sierra published on 1990 is checked out by some user with name Amie Deep\n" +
                          "head first java authored by someone published on 2014 is checked out by some user with name Amie Deep\n";
        assertEquals(expected, library.checkedOutBooksStatus());
    }

    @Test
    public void shouldReturnMeTheUserInfoInFormattedOrderWhenICallGetUserInfoMethod() {
        library = new Library(new SimpleUser("some user", "some password", "Amie Deep", "Aman@pathashala.com", 523743276527l));

        String expected = String.format("%-40s %-40s %-40s %-40s\n", "library Number", "name", "email", "phoneNumber") +
                          String.format("%-40s %-40s %-40s %-40s\n", "some user", "Amie Deep", "Aman@pathashala.com", "523743276527");


        assertEquals(expected, library.getUserInfo());
    }
}