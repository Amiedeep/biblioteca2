//This class starts the biblioteca application.
package com.thoughtworks.biblioteca;

import com.thoughtworks.Operations.LogOutOperation;
import com.thoughtworks.Operations.Operation;
import com.thoughtworks.interpreters.*;
import com.thoughtworks.options.*;
import com.thoughtworks.users.GuestUser;
import com.thoughtworks.users.LibrarianUser;
import com.thoughtworks.users.SimpleUser;
import com.thoughtworks.users.User;

import java.util.Scanner;

public class BibliotecaApplication {

    private Display welcomeDisplay;
    private Display optionsDisplay;
    private ConsoleInput consoleInput;
    private Interpreter interpreter;
    private Library library;

    public BibliotecaApplication(Display welcomeDisplay, Display optionsDisplay, ConsoleInput consoleInput, GuestUserInterpreter interpreter, Library library) {
        this.welcomeDisplay = welcomeDisplay;
        this.optionsDisplay = optionsDisplay;
        this.consoleInput = consoleInput;
        this.interpreter = interpreter;
        this.library = library;
    }

    public static void main(String[] args) {
        Options options = new LogInOptions();
        String welcomeMessage = "Hey! Welcome to biblioteca";
        Library library = new Library(new GuestUser());
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(new Display(welcomeMessage),
                                                                                new Display(options.getOptions()),
                                                                                consoleInput,
                                                                                new GuestUserInterpreter(library, consoleInput),
                                                                                library);
        bibliotecaApplication.startApplication(new LogInPageInterpreter(library, consoleInput));
        bibliotecaApplication.start();
    }

    public void start() {
        printMenuOptions();
        takeUserInputAndInterpret();
    }

    public void takeUserInputAndInterpret() {
        while(true) {
            String option = consoleInput.getInput();
            Operation operation = interpreter.interpret(option);
            operation.executeOperation();
            if(operation.getClass() == LogOutOperation.class) {
                optionsDisplay = new Display(new LogInOptions().getOptions());
                printMenuOptions();
                break;
            }
            printMenuOptions();
        }
        library.setUser(new GuestUser());
        getLoginPageOptionAndInterpret(new LogInPageInterpreter(library, consoleInput));
        start();
    }

    public void printMenuOptions() {
        optionsDisplay.display();
    }

    public void printWelcomeMessage() {
        welcomeDisplay.display();
    }

    public void startApplication(LogInPageInterpreter logInPageInterpreter) {
        printWelcomeMessage();
        printMenuOptions();
        getLoginPageOptionAndInterpret(logInPageInterpreter);
    }

    private void getLoginPageOptionAndInterpret(LogInPageInterpreter logInPageInterpreter) {
        String option = consoleInput.getInput();
        User user = logInPageInterpreter.interpret(option);

        if(user == null) {
            printMenuOptions();
            getLoginPageOptionAndInterpret(logInPageInterpreter);
        }
        else if(user.getClass() == GuestUser.class) {
            library.setUser(user);
            optionsDisplay = new Display(new GuestUserOptions().getOptions());
            interpreter = new GuestUserInterpreter(library, consoleInput);
        }
        else if(user.getClass() == LibrarianUser.class) {
            library.setUser(user);
            optionsDisplay = new Display(new LibrarianOptions().getOptions());
            interpreter = new LibrarianUserInterpreter(library, consoleInput);
        }
        else if(user.getClass() == SimpleUser.class) {
            library.setUser(user);
            optionsDisplay = new Display(new SimpleUserOptions().getOptions());
            interpreter = new SimpleUserInterpreter(library, consoleInput);
        }
    }
}
