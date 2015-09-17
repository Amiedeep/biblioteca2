package com.thoughtworks.operations;

import com.thoughtworks.Operations.CheckedOutBooksStatusOperation;
import com.thoughtworks.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class CheckedOutBooksStatusOperationTest {

    private CheckedOutBooksStatusOperation checkedOutBooksStatusOperation;
    private Library library;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        library = mock(Library.class);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldDisplayTheMessageLibraryReturnedWhenICallExecuteOperationMethod() {
        checkedOutBooksStatusOperation = new CheckedOutBooksStatusOperation(library);

        when(library.checkedOutBooksStatus()).thenReturn("some message");

        checkedOutBooksStatusOperation.executeOperation();

        assertEquals("some message\n", outputStream.toString());

        verify(library, times(1)).checkedOutBooksStatus();
    }
}