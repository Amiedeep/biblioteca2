//This class takes a message and displays that message.
package com.thoughtworks.biblioteca;

public class View {

    private String message;

    public View(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println(message);
    }
}
