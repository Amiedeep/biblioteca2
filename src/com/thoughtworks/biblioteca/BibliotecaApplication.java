//This class starts the biblioteca application.
package com.thoughtworks.biblioteca;

public class BibliotecaApplication {

    private View welcomeView;
    private View displayView;

    public BibliotecaApplication(View welcomeView, View displayView) {
        this.welcomeView = welcomeView;
        this.displayView = displayView;
    }

    public static void main(String[] args) {
        Options options = new Options();
        String welcomeMessage = "Hey! Welcome to biblioteca";
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(new View(welcomeMessage),
                                                                                new View(options.getOptions()));
        bibliotecaApplication.start();
    }

    public void start() {
        printWelcomeMessage();
        printMenuOptions();
    }

    private void printMenuOptions() {
        displayView.display();
    }

    private void printWelcomeMessage() {
        welcomeView.display();
    }
}
