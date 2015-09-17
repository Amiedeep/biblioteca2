package com.thoughtworks.interpreters;

import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;
import com.thoughtworks.users.GuestUser;
import com.thoughtworks.users.LibrarianUser;
import com.thoughtworks.users.SimpleUser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogInPageInterpreterTest {

    private LogInPageInterpreter logInPageInterpreter;
    private ConsoleInput consoleInput;
    private Library library;
    private ByteArrayOutputStream outputStream;

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        consoleInput = mock(ConsoleInput.class);
        library = mock(Library.class);
        logInPageInterpreter = new LogInPageInterpreter(library, consoleInput);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldReturnMeNullWhenIPassOneToInterpretMethodAndGiveInvalidCredentials() {
        when(consoleInput.getInput()).thenReturn("some invalid libraryNumber", "some invalid password");
        when(library.logInUser("some invalid libraryNumber", "some invalid password")).thenReturn(null);

        assertNull(logInPageInterpreter.interpret("1"));
        assertEquals("Enter Library number :\n" + "Enter Password :\n", outputStream.toString());
    }

    @Test
    public void shouldReturnMeSimpleUserWhenIPassOneToInterpretMethodAndGiveValidSimpleUserCredentials() {
        when(consoleInput.getInput()).thenReturn("111-2222", "abcd");
        when(library.logInUser("111-2222", "abcd")).thenReturn(new SimpleUser("111-2222", "abcd", "Amie Deep", "Aman@pathashala.com", 523743276527l));

        assertEquals(logInPageInterpreter.interpret("1").getClass(), SimpleUser.class);
        assertEquals("Enter Library number :\n" + "Enter Password :\n", outputStream.toString());
    }

    @Test
    public void shouldReturnMeLibrarianUserWhenIPassOneToInterpretMethodAndGiveValidLibrarianUserCredentials() {
        when(consoleInput.getInput()).thenReturn("222-3333", "abcd");
        when(library.logInUser("222-3333", "abcd")).thenReturn(new LibrarianUser("222-3333", "abcd", "Amie Deep", "Aman@pathashala.com", 523743276527l));

        assertEquals(logInPageInterpreter.interpret("1").getClass(), LibrarianUser.class);
        assertEquals("Enter Library number :\n" + "Enter Password :\n", outputStream.toString());
    }

    @Test
    public void shouldReturnMeGuestUserWhenIPassTwoToInterpretMethod() {
        assertEquals(logInPageInterpreter.interpret("2").getClass(), GuestUser.class);
    }

    @Test
    public void shouldExitTheSystemWhenIPassDefaultChoiceToInterpretMethod() {
        exit.expectSystemExitWithStatus(0);

        logInPageInterpreter.interpret("6");
    }
}