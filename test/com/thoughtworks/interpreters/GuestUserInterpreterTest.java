package com.thoughtworks.interpreters;

import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;
import com.thoughtworks.interpreters.GuestUserInterpreter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GuestUserInterpreterTest {

    private GuestUserInterpreter guestUserInterpreter;
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
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        when(library.listBooks()).thenReturn("Book name");

        guestUserInterpreter.interpret("1");

        assertEquals("Book name\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayTheMessageLibraryReturnedWhenIPassTwoInInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        when(library.listMovies()).thenReturn("Movie name");

        guestUserInterpreter.interpret("2");

        assertEquals("Movie name\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayTheInvalidMessageWhenIPassSomeInvalidNumberInInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        guestUserInterpreter.interpret("8");

        assertEquals("Select a valid option!\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayTheInvalidMessageWhenIPassSomeInvalidInputInInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        guestUserInterpreter.interpret("abc");

        assertEquals("Select a valid option!\n", outputStream.toString());
    }

    @Test
    public void shouldExitTheSystemWhenUserChooseQuitOption() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        exit.expectSystemExitWithStatus(0);

        guestUserInterpreter.interpret("4");
    }

    @Test
    public void shouldCallTheCheckoutMovieMethodOfLibraryWhenIPassThreeInInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some movie");

        guestUserInterpreter.interpret("3");

        assertEquals("Enter movie name to checkout\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).checkOutMovie("some movie");
    }
}