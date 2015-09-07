package com.thoughtworks.biblioteca;

import java.util.Scanner;

public class ConsoleInput {

    private Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
