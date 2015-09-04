package com.thoughtworks.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApplication {

    private final List<String> listOfBooks = Arrays.asList("scjp", "head first java");

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start("Hey! Welcome to biblioteca");
    }

    public void start(String welcomeMessage) {
        printWelcomeMessage(welcomeMessage);
        System.out.println("List of books we have is: ");
        printBooks(listOfBooks);
    }

    private void printWelcomeMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    private void printBooks(List<String> books) {
        System.out.println(books);
    }
}
