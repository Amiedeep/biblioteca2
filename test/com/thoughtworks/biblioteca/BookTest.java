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
}