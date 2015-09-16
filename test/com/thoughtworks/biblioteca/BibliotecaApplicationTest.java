package com.thoughtworks.biblioteca;

import com.thoughtworks.interpreters.GuestUserInterpreter;
import com.thoughtworks.interpreters.LogInPageInterpreter;
import com.thoughtworks.users.GuestUser;
import com.thoughtworks.users.LibrarianUser;
import com.thoughtworks.users.SimpleUser;
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
    private GuestUserInterpreter guestUserInterpreter;
    private LogInPageInterpreter logInPageInterpreter;

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        welcomeDisplay = new Display("welcome display");
        optionDisplay = new Display("Display display");
        consoleInput = new ConsoleInput(new Scanner(System.in));
        guestUserInterpreter = new GuestUserInterpreter(new Library(new GuestUser()), consoleInput);
        logInPageInterpreter = mock(LogInPageInterpreter.class);
    }

    @Test
    public void shouldCallDisplayMethodOfOptionsDisplayObjectWhenICallPrintMenuOptions() {
        optionDisplay = mock(Display.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter);

        bibliotecaApplication.printMenuOptions();

        verify(optionDisplay, times(1)).display();
    }

    @Test
    public void shouldCallDisplayMethodOfWelcomeDisplayObjectWhenICallPrintWelcomeMessage() {
        welcomeDisplay = mock(Display.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter);

        bibliotecaApplication.printWelcomeMessage();

        verify(welcomeDisplay, times(1)).display();
    }

    @Test
    public void shouldTakeTheUserInputAndPerformOperationWhenICallTakeUserInputAndInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter);

        when(consoleInput.getInput()).thenReturn("1", "4");

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.takeUserInputAndInterpret();
    }

    @Test
    public void shouldVerifyIfAllMethodsAreCalledWhenICallStartMethod() {
        consoleInput = mock(ConsoleInput.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter);

        when(consoleInput.getInput()).thenReturn("4");

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.start();
    }

    @Test
    public void shouldPrintMeMenuOptionsAgainWhenIGetNullAsUser() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);

        when(consoleInput.getInput()).thenReturn("1", "1");
        when(logInPageInterpreter.interpret("1")).thenReturn(null, new SimpleUser("some dummy user", "some dummy password"));

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(2)).display();
    }

    @Test
    public void shouldSetTheInterpreterAsGuestUserInterpreterWhenIGetGuestUserFromInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);

        when(consoleInput.getInput()).thenReturn("2");
        when(logInPageInterpreter.interpret("2")).thenReturn(new GuestUser());

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(1)).display();
    }

    @Test
    public void shouldSetTheInterpreterAsLibrarianUserInterpreterWhenIGetLibrarianUserFromInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);

        when(consoleInput.getInput()).thenReturn("1");
        when(logInPageInterpreter.interpret("1")).thenReturn(new LibrarianUser("some username", "some password"));

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(1)).display();
    }

    @Test
    public void shouldSetTheInterpreterAsSimpleUserInterpreterWhenIGetSimpleUserFromInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);

        when(consoleInput.getInput()).thenReturn("1");
        when(logInPageInterpreter.interpret("1")).thenReturn(new SimpleUser("some username", "some password"));

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(1)).display();
    }
}