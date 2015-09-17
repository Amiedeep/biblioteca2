package com.thoughtworks.interpreters;

import com.thoughtworks.Operations.*;
import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class LibrarianUserInterpreterTest {

    private LibrarianUserInterpreter librarianUserInterpreter;
    private Library library;
    private ConsoleInput consoleInput;

    @Before
    public void setUp() {
        library = mock(Library.class);
        consoleInput = mock(ConsoleInput.class);
    }

    @Test
    public void shouldReturnListBookOperationWhenIPassOneToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(ListBooksOperation.class, librarianUserInterpreter.interpret("1").getClass());
    }

    @Test
    public void shouldReturnListMoviesOperationWhenIPassTwoToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(ListMoviesOperation.class, librarianUserInterpreter.interpret("2").getClass());
    }

    @Test
    public void shouldReturnCheckOutMovieOperationWhenIPassThreeToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(CheckOutMovieOperation.class, librarianUserInterpreter.interpret("3").getClass());
    }

    @Test
    public void shouldReturnCheckOutBookOperationWhenIPassFourToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(CheckOutBookOperation.class, librarianUserInterpreter.interpret("4").getClass());
    }

    @Test
    public void shouldReturnReturnBookOperationWhenIPassFiveToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(ReturnBookOperation.class, librarianUserInterpreter.interpret("5").getClass());
    }

    @Test
    public void shouldReturnCheckedOutBooksStatusOperationWhenIPassSixToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(CheckedOutBooksStatusOperation.class, librarianUserInterpreter.interpret("6").getClass());
    }

    @Test
    public void shouldReturnExitOperationWhenIPassSevenToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(ExitOperation.class, librarianUserInterpreter.interpret("7").getClass());
    }

    @Test
    public void shouldReturnLogOutOperationWhenIPassEightToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(LogOutOperation.class, librarianUserInterpreter.interpret("8").getClass());
    }

    @Test
    public void shouldReturnInvalidOperationWhenIPassFiftyToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(InvalidOperation.class, librarianUserInterpreter.interpret("50").getClass());
    }

    @Test
    public void shouldReturnInvalidOperationWhenIPassAbcToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(InvalidOperation.class, librarianUserInterpreter.interpret("abc").getClass());
    }

    @Test
    public void shouldReturnUserInfoOperationWhenIPassNineToInterpretMethod() {
        librarianUserInterpreter = new LibrarianUserInterpreter(library, consoleInput);

        assertEquals(UserInfoOperation.class, librarianUserInterpreter.interpret("9").getClass());
    }
}