package com.thoughtworks.biblioteca;

public class BibliotecaApplication {

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }

    public void start() {
        printWelcomeMessage("Hey! Welcome to biblioteca");
    }

    public void printWelcomeMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }
}
