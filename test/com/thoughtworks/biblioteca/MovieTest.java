package com.thoughtworks.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovieTest {

    private Movie movie;

    @Test
    public void shouldShowMeTheMovieDetailInFormattedOrder() {
        movie = new Movie("Messenger of god", 2014, "Someone really good", 0);
        String expectedString = String.format("%-40s %-40s %-40s %-40s\n", "Messenger of god", 2014, "Someone really good", 0);

        assertEquals(expectedString, movie.toString());
    }

    @Test
    public void shouldReturnMeFalseifIPassNullAsParameterInCompareMovieNameWithMethod() {
        movie = new Movie("harry potter", 2010, "Some one", 4);

        assertEquals(false, movie.compareMovieNameWith(null));
    }

    @Test
    public void shouldReturnMeFalseifIPassDifferentNameAsParameterInCompareMovieNameWithMethod() {
        movie = new Movie("harry potter", 2010, "Some one", 4);

        assertEquals(false, movie.compareMovieNameWith("some non-sense"));
    }

    @Test
    public void shouldReturnMeTrueIfIPassSameMovieNameAsParameterInCompareMovieNameWithMethod() {
        movie = new Movie("harry potter", 2010, "Some one", 4);

        assertEquals(true, movie.compareMovieNameWith("harry potter"));
    }
}