package com.thoughtworks.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookListTest {

    private BookList bookList;

    @Test
    public void shouldShowListOfBooksInFormattedOrder() {
        bookList = new BookList();

        String expected ="List of books we have is: \n" +
                "scjp                                     kathy sierra                             1990                                    \n"+
                "head first java                          someone                                  2014                                    \n";
        assertEquals(expected, bookList.listBooks());
    }
}