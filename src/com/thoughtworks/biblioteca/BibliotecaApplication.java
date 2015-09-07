//This class starts the biblioteca application.
package com.thoughtworks.biblioteca;

public class BibliotecaApplication {

    private DisplayConsole displayConsole;
    private Options menuOptions;

    public BibliotecaApplication(Options menuOptions) {
        this.menuOptions = menuOptions;
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(new Options());
        bibliotecaApplication.start("Hey! Welcome to biblioteca");
    }

    public void start(String welcomeMessage) {
        displayConsole = new DisplayConsole(welcomeMessage);
        printWelcomeMessage(displayConsole);
        getAndPrintMenuOption();
    }

    public void getAndPrintMenuOption() {
        String options = getMenuOptions();
        displayConsole = new DisplayConsole(options);
        printMenuOptions(displayConsole);
    }

    public void printMenuOptions(DisplayConsole displayConsole) {
        displayConsole.display();
    }

    public String getMenuOptions() {
        return menuOptions.getOptions();
    }

    public void printWelcomeMessage(DisplayConsole displayConsole) {
        displayConsole.display();
    }
}
