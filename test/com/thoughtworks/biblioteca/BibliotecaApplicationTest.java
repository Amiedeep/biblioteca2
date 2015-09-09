package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.util.Scanner;

import static org.mockito.Mockito.*;

public class BibliotecaApplicationTest {

    private BibliotecaApplication bibliotecaApplication;
    private Display welcomeDisplay;
    private Display optionDisplay;
    private ConsoleInput consoleInput;
    private Interpreter interpreter;

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        welcomeDisplay = new Display("welcome display");
        optionDisplay = new Display("Display display");
        consoleInput = new ConsoleInput(new Scanner(System.in));
        interpreter = new Interpreter(new Library(), consoleInput);
    }

    @Test
    public void shouldCallDisplayMethodOfOptionsDisplayObjectWhenICallPrintMenuOptions() {
        optionDisplay = mock(Display.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, interpreter);

        bibliotecaApplication.printMenuOptions();

        verify(optionDisplay, times(1)).display();
    }

    @Test
    public void shouldCallDisplayMethodOfWelcomeDisplayObjectWhenICallPrintWelcomeMessage() {
        welcomeDisplay = mock(Display.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, interpreter);

        bibliotecaApplication.printWelcomeMessage();

        verify(welcomeDisplay, times(1)).display();
    }

    @Test
    public void shouldTakeTheUserInputAndPerformOperationWhenICallTakeUserInputAndInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, interpreter);

        when(consoleInput.getInput()).thenReturn("1", "3");

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.takeUserInputAndInterpret();
    }

    @Test
    public void shouldVerifyIfAllMethodsAreCalledWhenICallStartMethod() {
        consoleInput = mock(ConsoleInput.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, interpreter);

        when(consoleInput.getInput()).thenReturn("3");

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.start();
    }
}