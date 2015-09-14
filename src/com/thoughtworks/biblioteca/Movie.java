//Movie class which creates and display the movie.
package com.thoughtworks.biblioteca;

public class Movie {

    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%-40s %-40s %-40s %-40s\n", name, year, director, rating);
    }
}
