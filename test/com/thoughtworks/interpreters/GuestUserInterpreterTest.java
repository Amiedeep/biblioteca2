package com.thoughtworks.interpreters;

import com.thoughtworks.Operations.*;
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

    @Before
    public void setUp() {
        library = mock(Library.class);
        consoleInput = mock(ConsoleInput.class);
    }

    @Test
    public void shouldReturnListBookOperationWhenIPassOneToInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        assertEquals(ListBooksOperation.class, guestUserInterpreter.interpret("1").getClass());
    }

    @Test
    public void shouldReturnListMoviesOperationWhenIPassTwoToInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        assertEquals(ListMoviesOperation.class, guestUserInterpreter.interpret("2").getClass());
    }

    @Test
    public void shouldReturnCheckOutMovieOperationWhenIPassThreeToInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        assertEquals(CheckOutMovieOperation.class, guestUserInterpreter.interpret("3").getClass());
    }

    @Test
    public void shouldReturnExitOperationWhenIPassFourToInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        assertEquals(ExitOperation.class, guestUserInterpreter.interpret("4").getClass());
    }

    @Test
    public void shouldReturnInvalidOperationWhenIPassEightToInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        assertEquals(InvalidOperation.class, guestUserInterpreter.interpret("8").getClass());
    }

    @Test
    public void shouldReturnInvalidOperationWhenIPassAbcToInterpretMethod() {
        guestUserInterpreter = new GuestUserInterpreter(library, consoleInput);

        assertEquals(InvalidOperation.class, guestUserInterpreter.interpret("abc").getClass());
    }
}