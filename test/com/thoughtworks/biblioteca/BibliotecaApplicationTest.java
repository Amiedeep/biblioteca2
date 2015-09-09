package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.util.Scanner;

import static org.mockito.Mockito.*;

public class BibliotecaApplicationTest {

    private BibliotecaApplication bibliotecaApplication;
    private View welcomeView;
    private View optionView;
    private ConsoleInput consoleInput;
    private Interpreter interpreter;

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        welcomeView = new View("welcome view");
        optionView = new View("Display view");
        consoleInput = new ConsoleInput(new Scanner(System.in));
        interpreter = new Interpreter(new Library(), consoleInput);
    }

    @Test
    public void shouldCallDisplayMethodOfDisplayViewWhenICallPrintMenuOptions() {
        optionView = mock(View.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeView, optionView, consoleInput, interpreter);

        bibliotecaApplication.printMenuOptions();

        verify(optionView, times(1)).display();
    }

    @Test
    public void shouldCallDisplayMethodOfWelcomeViewWhenICallPrintWelcomeMessage() {
        welcomeView = mock(View.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeView, optionView, consoleInput, interpreter);

        bibliotecaApplication.printWelcomeMessage();

        verify(welcomeView, times(1)).display();
    }

    @Test
    public void shouldTakeTheUserInputAndPerformOperationWhenICallTakeUserInputAndInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeView, optionView, consoleInput, interpreter);

        when(consoleInput.getInput()).thenReturn("1", "3");

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.takeUserInputAndInterpret();
    }

    @Test
    public void shouldVerifyIfAllMethodsAreCalledWhenICallStartMethod() {
        consoleInput = mock(ConsoleInput.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeView, optionView, consoleInput, interpreter);

        when(consoleInput.getInput()).thenReturn("3");

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.start();
    }
}