package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class InterpreterTest {

    private Interpreter interpreter;
    private Library library;
    private ConsoleInput consoleInput;
    private ByteArrayOutputStream outputStream;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        library = mock(Library.class);
        consoleInput = mock(ConsoleInput.class);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldDisplayTheMessageLibraryReturnedWhenIPassOneInInterpretMethod() {
        interpreter = new Interpreter(library, consoleInput);

        when(library.listBooks()).thenReturn("Book name");

        interpreter.interpret("1");

        assertEquals("Book name\n", outputStream.toString());
    }

    @Test
    public void shouldCallTheCheckoutMethodOfLibraryWhenIPassTwoInInterpretMethod() {
        interpreter = new Interpreter(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some book");

        interpreter.interpret("2");

        assertEquals("Enter book name to checkout\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).checkOutBook("some book");
    }

    @Test
    public void shouldDisplayTheInvalidMessageWhenIPassSomeInvalidNumberInInterpretMethod() {
        interpreter = new Interpreter(library, consoleInput);

        interpreter.interpret("8");

        assertEquals("Select a valid option!\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayTheInvalidMessageWhenIPassSomeInvalidInputInInterpretMethod() {
        interpreter = new Interpreter(library, consoleInput);

        interpreter.interpret("abc");

        assertEquals("Select a valid option!\n", outputStream.toString());
    }

    @Test
    public void shouldExitTheSystemWhenUserChooseQuitOption() {
        interpreter = new Interpreter(library, consoleInput);

        exit.expectSystemExitWithStatus(0);

        interpreter.interpret("3");
    }

    @Test
    public void shouldCallTheReturnBookMethodOfLibraryWhenIPassFourInInterpretMethod() {
        interpreter = new Interpreter(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some book");

        interpreter.interpret("4");

        assertEquals("Enter book name to return\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).returnBook("some book");
    }
}