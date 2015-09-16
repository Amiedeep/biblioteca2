package com.thoughtworks.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookTest {

    private Book book;

    @Test
    public void shouldShowMeTheBookDetailInFormattedOrder() {
        String expectedString = String.format("%-40s %-40s %-40s\n", "harry potter", "someone really good", 2010);
        book = new Book("harry potter", "someone really good", 2010);

        assertEquals(expectedString, book.toString());
    }

    @Test
    public void shouldReturnMeFalseifIPassNullAsParameterInCompareBookNameWithMethod() {
        book = new Book("harry potter", "someone really good", 2010);

        assertEquals(false, book.compareBookNameWith(null));
    }

    @Test
    public void shouldReturnMeFalseifIPassDifferentNameAsParameterInCompareBookNameWithMethod() {
        book = new Book("harry potter", "someone really good", 2010);

        assertEquals(false, book.compareBookNameWith("Some non existing book"));
    }

    @Test
    public void shouldReturnMeTrueIfIPassSameBookNameAsParameterInCompareBookNameWithMethod() {
        book = new Book("harry potter", "someone really good", 2010);

        assertEquals(true, book.compareBookNameWith("harry potter"));
    }

    @Test
    public void shouldReturnMeBookInfoInFormattedOrderWhenICallBookInfoMethod() {
        book = new Book("some book", "some author", 1947);

        assertEquals("some book authored by some author published on 1947", book.bookInfo());
    }
}