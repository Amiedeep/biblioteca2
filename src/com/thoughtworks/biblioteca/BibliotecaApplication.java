//This class starts the biblioteca application.
package com.thoughtworks.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApplication {

    private final List<String> listOfBooks = Arrays.asList("scjp", "head first java");
    private DisplayConsole displayConsole;

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start("Hey! Welcome to biblioteca");
    }

    public void start(String welcomeMessage) {
        printWelcomeMessage(welcomeMessage);
        printBooks(listOfBooks);
    }

    private void printWelcomeMessage(String welcomeMessage) {
        displayConsole = new DisplayConsole(welcomeMessage);
        displayConsole.display();
    }

    private void printBooks(List<String> books) {
        displayConsole = new DisplayConsole("List of books we have is: \n"+books);
        displayConsole.display();
    }
}
