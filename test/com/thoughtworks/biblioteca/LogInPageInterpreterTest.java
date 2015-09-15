package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

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
        when(consoleInput.getInput()).thenReturn("some invalid username", "some invalid password");
        when(library.logInUser("some invalid username", "some invalid password")).thenReturn(null);

        assertNull(logInPageInterpreter.interpret("1"));
        assertEquals("Enter Library number :\n" + "Enter Password :\n", outputStream.toString());
    }
}