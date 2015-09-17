package com.thoughtworks.biblioteca;

import com.thoughtworks.Operations.ExitOperation;
import com.thoughtworks.Operations.ListBooksOperation;
import com.thoughtworks.interpreters.GuestUserInterpreter;
import com.thoughtworks.interpreters.LogInPageInterpreter;
import com.thoughtworks.users.GuestUser;
import com.thoughtworks.users.LibrarianUser;
import com.thoughtworks.users.SimpleUser;
import com.thoughtworks.users.User;
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
    private Library library;

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        welcomeDisplay = new Display("welcome display");
        optionDisplay = new Display("Display display");
        consoleInput = new ConsoleInput(new Scanner(System.in));
        library = new Library(new GuestUser());
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);
        logInPageInterpreter = mock(LogInPageInterpreter.class);
    }

    @Test
    public void shouldCallDisplayMethodOfOptionsDisplayObjectWhenICallPrintMenuOptions() {
        optionDisplay = mock(Display.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter, library);

        bibliotecaApplication.printMenuOptions();

        verify(optionDisplay, times(1)).display();
    }

    @Test
    public void shouldCallDisplayMethodOfWelcomeDisplayObjectWhenICallPrintWelcomeMessage() {
        welcomeDisplay = mock(Display.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter, library);

        bibliotecaApplication.printWelcomeMessage();

        verify(welcomeDisplay, times(1)).display();
    }

    @Test
    public void shouldTakeTheUserInputAndPerformOperationWhenICallTakeUserInputAndInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        guestUserInterpreter = mock(GuestUserInterpreter.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter, library);

        when(consoleInput.getInput()).thenReturn("1", "4");
        when(guestUserInterpreter.interpret("1")).thenReturn(new ListBooksOperation(new Library(new GuestUser())));
        when(guestUserInterpreter.interpret("4")).thenReturn(new ExitOperation());

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.takeUserInputAndInterpret();

        verify(guestUserInterpreter, times(1)).interpret("1");
        verify(guestUserInterpreter, times(1)).interpret("4");
    }

    @Test
    public void shouldVerifyIfAllMethodsAreCalledWhenICallStartMethod() {
        consoleInput = mock(ConsoleInput.class);
        guestUserInterpreter = mock(GuestUserInterpreter.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter, library);

        when(consoleInput.getInput()).thenReturn("4");
        when(guestUserInterpreter.interpret("4")).thenReturn(new ExitOperation());

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.start();

        verify(guestUserInterpreter, times(1)).interpret("4");
        verify(consoleInput, times(1)).getInput();
    }

    @Test
    public void shouldPrintMeMenuOptionsAgainWhenIGetNullAsUser() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);
        library = mock(Library.class);
        User user = new SimpleUser("some dummy user", "some dummy password");

        when(consoleInput.getInput()).thenReturn("1", "1");
        when(logInPageInterpreter.interpret("1")).thenReturn(null, user);

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter, library);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(2)).display();
        verify(library, times(1)).setUser(user);
    }

    @Test
    public void shouldSetTheInterpreterAsGuestUserInterpreterWhenIGetGuestUserFromInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);
        library = mock(Library.class);
        User user = new GuestUser();

        when(consoleInput.getInput()).thenReturn("2");
        when(logInPageInterpreter.interpret("2")).thenReturn(user);

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter, library);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(1)).display();
        verify(library, times(1)).setUser(user);
    }

    @Test
    public void shouldSetTheInterpreterAsLibrarianUserInterpreterWhenIGetLibrarianUserFromInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);
        library = mock(Library.class);
        User user = new LibrarianUser("some libraryNumber", "some password");

        when(consoleInput.getInput()).thenReturn("1");
        when(logInPageInterpreter.interpret("1")).thenReturn(user);

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter, library);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(1)).display();
        verify(library, times(1)).setUser(user);
    }

    @Test
    public void shouldSetTheInterpreterAsSimpleUserInterpreterWhenIGetSimpleUserFromInterpretMethod() {
        consoleInput = mock(ConsoleInput.class);
        optionDisplay = mock(Display.class);
        library = mock(Library.class);
        User user = new SimpleUser("some libraryNumber", "some password");

        when(consoleInput.getInput()).thenReturn("1");
        when(logInPageInterpreter.interpret("1")).thenReturn(user);

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter, library);

        bibliotecaApplication.startApplication(logInPageInterpreter);

        verify(optionDisplay, times(1)).display();
        verify(library, times(1)).setUser(user);
    }

    @Test
    public void shouldChangeTheOptionsAndTheUserAndExitsFromWhileLoopWhenILogOut() {
        consoleInput = mock(ConsoleInput.class);

        when(consoleInput.getInput()).thenReturn("5", "2", "4");

        bibliotecaApplication = new BibliotecaApplication(welcomeDisplay, optionDisplay, consoleInput, guestUserInterpreter, library);

        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.takeUserInputAndInterpret();
    }
}