package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaApplicationTest {

    private BibliotecaApplication bibliotecaApplication;
    private Display welcomeDisplay;
    private Display optionDisplay;
    private ConsoleInput consoleInput;
    private SimpleUserInterpreter simpleUserInterpreter;
    private LogInPageInterpreter logInPageInterpreter;

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        welcomeDisplay = new Display("welcome display");
        optionDisplay = new Display("Display display");
        consoleInput = new ConsoleInput(new Scanner(System.in));
        simpleUserInterpreter = new SimpleUserInterpreter(new Library(), consoleInput);
        logInPageInterpreter = mock(LogInPageInterpreter.class);
    }

    @Test
    public void shouldCallDisplayMethodOfOptionsDisplayObjectWhenICallPrintMenuOptions() {
        optionDisplay = mock(Display.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, simpleUserInterpreter);

        bibliotecaApplication.printMenuOptions();

        verify(optionDisplay, times(1)).display();
    }

    @Test
    public void shouldCallDisplayMethodOfWelcomeDisplayObjectWhenICallPrintWelcomeMessage() {
        welcomeDisplay = mock(Display.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, simpleUserInterpreter);

        bibliotecaApplication.printWelcomeMessage();

        verify(welcomeDisplay, times(1)).display();
    }

    @Test
    public void shouldTakeTheUserInputAndPerformOperationWhenICallTakeUserInputAndInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, simpleUserInterpreter);

        when(consoleInput.getInput()).thenReturn("1", "3");

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.takeUserInputAndInterpret();
    }

    @Test
    public void shouldVerifyIfAllMethodsAreCalledWhenICallStartMethod() {
        consoleInput = mock(ConsoleInput.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, simpleUserInterpreter);

        when(consoleInput.getInput()).thenReturn("3");

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.start();
    }

    @Test
    public void shouldPrintMeMenuOptionsAgainWhenIGetNullAsUser() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);

        when(consoleInput.getInput()).thenReturn("1", "1");
        when(logInPageInterpreter.interpret("1")).thenReturn(null, new SimpleUser("some dummy user", "some dummy password"));

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, simpleUserInterpreter);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(2)).display();
    }

    @Test
    public void shouldSetTheInterpreterAsGuestUserInterpreterWhenIGetGuestUserFromInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);

        when(consoleInput.getInput()).thenReturn("2");
        when(logInPageInterpreter.interpret("2")).thenReturn(new GuestUser());

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, simpleUserInterpreter);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(1)).display();
    }
}