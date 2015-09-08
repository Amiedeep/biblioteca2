//Book class which creates and display the book
package com.thoughtworks.biblioteca;

public class Book {

    private String name;
    private String author;
    private int yearPublished;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return String.format("%-40s %-40s %-40s\n", name, author, yearPublished);
    }

    public boolean compareBookNameWith(String thatName) {
        return false;
    }
}
