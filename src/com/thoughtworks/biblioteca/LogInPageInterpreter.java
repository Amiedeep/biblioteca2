//This class interprets and return some concrete object against logIn page options.
package com.thoughtworks.biblioteca;

public class LogInPageInterpreter {

    private ConsoleInput consoleInput;
    private Library library;

    public LogInPageInterpreter(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    public User interpret(String choice) {
        User user = null;
        switch (choice) {
            case "1" :
                user = logIn();
                break;
        }
        return user;
    }

    private User logIn() {
        new Display("Enter Library number :").display();
        String userName = consoleInput.getInput();
        new Display("Enter Password :").display();
        String password = consoleInput.getInput();
        return null;
    }
}
