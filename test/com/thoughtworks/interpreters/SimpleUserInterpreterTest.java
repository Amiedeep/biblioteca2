package com.thoughtworks.interpreters;

import com.thoughtworks.Operations.*;
import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class SimpleUserInterpreterTest {

    private SimpleUserInterpreter simpleUserInterpreter;
    private Library library;
    private ConsoleInput consoleInput;

    @Before
    public void setUp() {
        library = mock(Library.class);
        consoleInput = mock(ConsoleInput.class);
    }

    @Test
    public void shouldReturnListBookOperationWhenIPassOneToInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        assertEquals(ListBooksOperation.class, simpleUserInterpreter.interpret("1").getClass());
    }

    @Test
    public void shouldReturnListMoviesOperationWhenIPassFiveToInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        assertEquals(ListMoviesOperation.class, simpleUserInterpreter.interpret("5").getClass());
    }

    @Test
    public void shouldReturnCheckOutMovieOperationWhenIPassSixToInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        assertEquals(CheckOutMovieOperation.class, simpleUserInterpreter.interpret("6").getClass());
    }

    @Test
    public void shouldReturnCheckOutBookOperationWhenIPassTwoToInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        assertEquals(CheckOutBookOperation.class, simpleUserInterpreter.interpret("2").getClass());
    }

    @Test
    public void shouldReturnReturnBookOperationWhenIPassFourToInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        assertEquals(ReturnBookOperation.class, simpleUserInterpreter.interpret("4").getClass());
    }

    @Test
    public void shouldReturnExitOperationWhenIPassThreeToInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        assertEquals(ExitOperation.class, simpleUserInterpreter.interpret("3").getClass());
    }

    @Test
    public void shouldReturnInvalidOperationWhenIPassEightToInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        assertEquals(InvalidOperation.class, simpleUserInterpreter.interpret("8").getClass());
    }

    @Test
    public void shouldReturnInvalidOperationWhenIPassAbcToInterpretMethod() {
        simpleUserInterpreter = new SimpleUserInterpreter(library, consoleInput);

        assertEquals(InvalidOperation.class, simpleUserInterpreter.interpret("abc").getClass());
    }
}