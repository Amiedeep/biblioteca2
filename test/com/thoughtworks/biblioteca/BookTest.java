package com.thoughtworks.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookTest {

    private Book book;

    @Test
    public void shouldShowMeTheBookDetailInFormattedOrder() {
        book = new Book("harry potter", "someone really good", 2010);

        assertEquals("harry potter                             someone really good                      2010                                    \n",
                     book.toString());
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
}