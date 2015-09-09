//This class starts the biblioteca application.
package com.thoughtworks.biblioteca;

import java.util.Scanner;

public class BibliotecaApplication {

    private View welcomeView;
    private View optionsView;
    private ConsoleInput consoleInput;
    private Interpreter interpreter;

    public BibliotecaApplication(View welcomeView, View optionsView, ConsoleInput consoleInput, Interpreter interpreter) {
        this.welcomeView = welcomeView;
        this.optionsView = optionsView;
        this.consoleInput = consoleInput;
        this.interpreter = interpreter;
    }

    public static void main(String[] args) {
        Options options = new Options();
        String welcomeMessage = "Hey! Welcome to biblioteca";
        Library library = new Library();
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(new View(welcomeMessage),
                                                                                new View(options.getOptions()),
                                                                                consoleInput,
                                                                                new Interpreter(library, consoleInput));
        bibliotecaApplication.start();
    }

    public void start() {
        printWelcomeMessage();
        printMenuOptions();
        takeUserInputAndInterpret();
    }

    public void takeUserInputAndInterpret() {
        while(true) {
            String option = consoleInput.getInput();
            interpreter.interpret(option);
            printMenuOptions();
        }
    }

    public void printMenuOptions() {
        optionsView.display();
    }

    public void printWelcomeMessage() {
        welcomeView.display();
    }
}
