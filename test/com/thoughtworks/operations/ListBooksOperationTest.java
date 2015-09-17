package com.thoughtworks.operations;

import com.thoughtworks.Operations.ListBooksOperation;
import com.thoughtworks.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class ListBooksOperationTest {

    private ListBooksOperation listBooksOperation;
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
        listBooksOperation = new ListBooksOperation(library);

        when(library.listBooks()).thenReturn("Book name");

        listBooksOperation.executeOperation();

        assertEquals("Book name\n", outputStream.toString());

        verify(library, times(1)).listBooks();
    }
}