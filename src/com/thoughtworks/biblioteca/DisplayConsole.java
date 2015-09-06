//This class takes a message and displays that message.
package com.thoughtworks.biblioteca;

public class DisplayConsole {

    private String message;

    public DisplayConsole(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println(message);
    }
}
