//This class takes a message and displays that message.
package com.thoughtworks.biblioteca;

public class Display {

    private String message;

    public Display(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println(message);
    }
}
