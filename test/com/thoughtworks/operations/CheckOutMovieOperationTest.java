package com.thoughtworks.operations;

import com.thoughtworks.Operations.CheckOutMovieOperation;
import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CheckOutMovieOperationTest {

    private CheckOutMovieOperation checkOutMovieOperation;
    private Library library;
    private ConsoleInput consoleInput;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        library = mock(Library.class);
        consoleInput = mock(ConsoleInput.class);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldCheckThatLibraryMethodsAreCalledWhenICallExecuteOperation() {
        checkOutMovieOperation = new CheckOutMovieOperation(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some movie");

        checkOutMovieOperation.executeOperation();

        assertEquals("Enter movie name to checkout\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).checkOutMovie("some movie");
    }
}