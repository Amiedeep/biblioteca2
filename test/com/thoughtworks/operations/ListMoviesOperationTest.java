package com.thoughtworks.operations;

import com.thoughtworks.Operations.ListMoviesOperation;
import com.thoughtworks.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class ListMoviesOperationTest {

    private ListMoviesOperation listMoviesOperation;
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
        listMoviesOperation = new ListMoviesOperation(library);

        when(library.listMovies()).thenReturn("Movie name");

        listMoviesOperation.executeOperation();

        assertEquals("Movie name\n", outputStream.toString());

        verify(library, times(1)).listMovies();
    }
}