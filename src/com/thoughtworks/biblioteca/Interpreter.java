//It takes the input, Interpret it and return the view.
package com.thoughtworks.biblioteca;

public class Interpreter {
    private Library library;

    public Interpreter(Library library) {
        this.library = library;
    }

    public void interpret(String input) {
        int option = Integer.parseInt(input);
        switch (option) {
            case 1:
                String bookList = library.listBooks();
                new View(bookList).display();
                break;
        }
    }
}
