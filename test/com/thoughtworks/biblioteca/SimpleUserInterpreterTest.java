package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class SimpleUserInterpreterTest {

    private SimpleUserInterpreter simpleUserInterpreter;
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
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        when(library.listBooks()).thenReturn("Book name");

        simpleUserInterpreter.interpret("1");

        assertEquals("Book name\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayTheMessageLibraryReturnedWhenIPassFiveInInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        when(library.listMovies()).thenReturn("Movie name");

        simpleUserInterpreter.interpret("5");

        assertEquals("Movie name\n", outputStream.toString());
    }

    @Test
    public void shouldCallTheCheckoutMethodOfLibraryWhenIPassTwoInInterpretMethodAndPrintSomeReturnedMessage() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some book");
        when(library.checkOutBook("some book")).thenReturn("Some book message");

        simpleUserInterpreter.interpret("2");

        assertEquals("Enter book name to checkout\nSome book message\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).checkOutBook("some book");
    }

    @Test
    public void shouldDisplayTheInvalidMessageWhenIPassSomeInvalidNumberInInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        simpleUserInterpreter.interpret("8");

        assertEquals("Select a valid option!\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayTheInvalidMessageWhenIPassSomeInvalidInputInInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        simpleUserInterpreter.interpret("abc");

        assertEquals("Select a valid option!\n", outputStream.toString());
    }

    @Test
    public void shouldExitTheSystemWhenUserChooseQuitOption() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        exit.expectSystemExitWithStatus(0);

        simpleUserInterpreter.interpret("3");
    }

    @Test
    public void shouldCallTheReturnBookMethodOfLibraryWhenIPassFourInInterpretMethodAndPrintSomeReturnedMessage() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some book");
        when(library.returnBook("some book")).thenReturn("some book message");

        simpleUserInterpreter.interpret("4");

        assertEquals("Enter book name to return\nsome book message\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).returnBook("some book");
    }

    @Test
    public void shouldCallTheCheckoutMovieMethodOfLibraryWhenIPassSixInInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some movie");

        simpleUserInterpreter.interpret("6");

        assertEquals("Enter movie name to checkout\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).checkOutMovie("some movie");
    }
}