//This class starts the biblioteca application.
package com.thoughtworks.biblioteca;

public class BibliotecaApplication {

    private DisplayConsole displayConsole;

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start("Hey! Welcome to biblioteca");
    }

    public void start(String welcomeMessage) {
        displayConsole = new DisplayConsole(welcomeMessage);
        printWelcomeMessage(displayConsole);
    }

    public void printWelcomeMessage(DisplayConsole displayConsole) {
        displayConsole.display();
    }
}
