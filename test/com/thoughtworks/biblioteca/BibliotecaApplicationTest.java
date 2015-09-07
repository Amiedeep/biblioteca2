package com.thoughtworks.biblioteca;

import org.junit.Test;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class BibliotecaApplicationTest {

    private BibliotecaApplication bibliotecaApplication;
    private View welcomeView;
    private View displayView;
    private View bookView;
    private ConsoleInput consoleInput;

    @Test
    public void shouldCallDisplayMethodOfDisplayViewWhenICallPrintMenuOptions() {
        welcomeView = new View("welcome view");
        bookView = new View("book view");
        displayView = mock(View.class);
        consoleInput = new ConsoleInput(new Scanner(System.in));
        bibliotecaApplication = new BibliotecaApplication(welcomeView, displayView, bookView, consoleInput);

        bibliotecaApplication.printMenuOptions();

        verify(displayView, times(1)).display();
    }

    @Test
    public void shouldCallDisplayMethodOfWelcomeViewWhenICallPrintWelcomeMessage() {
        welcomeView = mock(View.class);
        bookView = new View("book view");
        displayView = new View("Display view");
        consoleInput = new ConsoleInput(new Scanner(System.in));
        bibliotecaApplication = new BibliotecaApplication(welcomeView, displayView, bookView, consoleInput);

        bibliotecaApplication.printWelcomeMessage();

        verify(welcomeView, times(1)).display();
    }

    @Test
    public void shouldReturnMeProperDisplayWhenIChooseOptionInTakeUserInputMethod() {
        welcomeView = new View("Welcome view");
        bookView = mock(View.class);
        displayView = new View("Display view");
        consoleInput = mock(ConsoleInput.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeView, displayView, bookView, consoleInput);

        when(consoleInput.getInput()).thenReturn("1","2");

        bibliotecaApplication.takeUserInput();

        verify(bookView, times(1)).display();
        verify(consoleInput, times(2)).getInput();
    }
}