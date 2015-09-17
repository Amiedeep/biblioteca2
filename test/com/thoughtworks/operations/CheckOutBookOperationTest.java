package com.thoughtworks.operations;

import com.thoughtworks.Operations.CheckOutBookOperation;
import com.thoughtworks.biblioteca.ConsoleInput;
import com.thoughtworks.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class CheckOutBookOperationTest {

    private CheckOutBookOperation checkOutBookOperation;
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
    public void shouldDisplayTheMessageLibraryReturnedWhenICallExecuteOperationMethod() {
        checkOutBookOperation = new CheckOutBookOperation(library, consoleInput);

        when(consoleInput.getInput()).thenReturn("some book");
        when(library.checkOutBook("some book")).thenReturn("Some book message");

        checkOutBookOperation.executeOperation();

        assertEquals("Enter book name to checkout\nSome book message\n", outputStream.toString());

        verify(consoleInput, times(1)).getInput();
        verify(library, times(1)).checkOutBook("some book");
    }
}