package com.thoughtworks.interpreters;

import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;
import com.thoughtworks.interpreters.LibrarianUserInterpreter;
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

public class LibrarianUserInterpreterTest {

    private LibrarianUserInterpreter librarianUserInterpreter;
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
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        when(library.listBooks()).thenReturn("Book name");

        librarianUserInterpreter.interpret("1");

        assertEquals("Book name\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayTheMessageLibraryReturnedWhenIPassTwoInInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        when(library.listMovies()).thenReturn("Movie name");

        librarianUserInterpreter.interpret("2");

        assertEquals("Movie name\n", outputStream.toString());
    }

    @Test
    public void shouldCallTheCheckoutMethodOfLibraryWhenIPassFourInInterpretMethodAndPrintSomeReturnedMessage() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some book");
        when(library.checkOutBook("some book")).thenReturn("Some book message");

        librarianUserInterpreter.interpret("4");

        assertEquals("Enter book name to checkout\nSome book message\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).checkOutBook("some book");
    }

    @Test
    public void shouldDisplayTheInvalidMessageWhenIPassSomeInvalidNumberInInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        librarianUserInterpreter.interpret("8");

        assertEquals("Select a valid option!\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayTheInvalidMessageWhenIPassSomeInvalidInputInInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        librarianUserInterpreter.interpret("abc");

        assertEquals("Select a valid option!\n", outputStream.toString());
    }

    @Test
    public void shouldExitTheSystemWhenUserChooseQuitOption() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        exit.expectSystemExitWithStatus(0);

        librarianUserInterpreter.interpret("7");
    }

    @Test
    public void shouldCallTheReturnBookMethodOfLibraryWhenIPassFiveInInterpretMethodAndPrintSomeReturnedMessage() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some book");
        when(library.returnBook("some book")).thenReturn("some book message");

        librarianUserInterpreter.interpret("5");

        assertEquals("Enter book name to return\nsome book message\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).returnBook("some book");
    }

    @Test
    public void shouldCallTheCheckoutMovieMethodOfLibraryWhenIPassThreeInInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some movie");

        librarianUserInterpreter.interpret("3");

        assertEquals("Enter movie name to checkout\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).checkOutMovie("some movie");
    }
}