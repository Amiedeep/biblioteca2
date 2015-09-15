//This class starts the biblioteca application.
package com.thoughtworks.biblioteca;

import java.util.Scanner;

public class BibliotecaApplication {

    private Display welcomeDisplay;
    private Display optionsDisplay;
    private ConsoleInput consoleInput;
    private Interpreter interpreter;

    public BibliotecaApplication(Display welcomeDisplay, Display optionsDisplay, ConsoleInput consoleInput, SimpleUserInterpreter interpreter) {
        this.welcomeDisplay = welcomeDisplay;
        this.optionsDisplay = optionsDisplay;
        this.consoleInput = consoleInput;
        this.interpreter = interpreter;
    }

    public static void main(String[] args) {
        Options options = new SimpleUserOptions();
        String welcomeMessage = "Hey! Welcome to biblioteca";
        Library library = new Library();
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(new Display(welcomeMessage),
                                                                                new Display(options.getOptions()),
                                                                                consoleInput,
                                                                                new SimpleUserInterpreter(library, consoleInput));
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
        optionsDisplay.display();
    }

    public void printWelcomeMessage() {
        welcomeDisplay.display();
    }
}
