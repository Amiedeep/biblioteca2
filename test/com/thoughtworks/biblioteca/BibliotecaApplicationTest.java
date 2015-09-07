package com.thoughtworks.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
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

    @Test
    public void shouldPrintMeInvaliMessageWhenIChooseInvalidOptionInTakeUserInputMethod() {
        welcomeView = new View("Welcome view");
        bookView = new View("Book view");
        displayView = new View("Display view");
        consoleInput = mock(ConsoleInput.class);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        bibliotecaApplication = new BibliotecaApplication(welcomeView, displayView, bookView, consoleInput);

        when(consoleInput.getInput()).thenReturn("3", "2");

        bibliotecaApplication.takeUserInput();

        assertEquals("Select a valid option!\n", outputStream.toString());

    }
}