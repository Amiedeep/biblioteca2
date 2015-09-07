//This class starts the biblioteca application.
package com.thoughtworks.biblioteca;

import java.util.Scanner;

public class BibliotecaApplication {

    private View welcomeView;
    private View bookView;
    private View displayView;
    private ConsoleInput consoleInput;

    public BibliotecaApplication(View welcomeView, View displayView,View bookView, ConsoleInput consoleInput) {
        this.welcomeView = welcomeView;
        this.displayView = displayView;
        this.bookView = bookView;
        this.consoleInput = consoleInput;
    }

    public static void main(String[] args) {
        Options options = new Options();
        String welcomeMessage = "Hey! Welcome to biblioteca";
        Library library = new Library();
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(new View(welcomeMessage),
                                                                                new View(options.getOptions()),
                                                                                new View(library.listBooks()),
                                                                                new ConsoleInput(new Scanner(System.in)));
        bibliotecaApplication.start();
    }

    public void start() {
        printWelcomeMessage();
        printMenuOptions();
        takeUserInput();
    }

    private void takeUserInput() {
        int option;
        View invalidOption = new View("Select a valid option!");
        while(true) {
            option = Integer.parseInt(consoleInput.getInput());
            switch(option) {
                case 1:
                    bookView.display();
                    break;
                default:
                    invalidOption.display();
            }
        }
    }

    public void printMenuOptions() {
        displayView.display();
    }

    public void printWelcomeMessage() {
        welcomeView.display();
    }
}
