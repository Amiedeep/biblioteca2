//This class interprets and return some concrete object against logIn page options.
package com.thoughtworks.interpreters;

import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;
import com.thoughtworks.users.GuestUser;
import com.thoughtworks.users.User;

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
            case "2" :
                user = new GuestUser();
                break;
            default :
                System.exit(0);
        }
        return user;
    }

    private User logIn() {
        new Display("Enter Library number :").display();
        String libraryNumber = consoleInput.getInput();
        new Display("Enter Password :").display();
        String password = consoleInput.getInput();
        User user = library.logInUser(libraryNumber, password);
        return user;
    }
}
