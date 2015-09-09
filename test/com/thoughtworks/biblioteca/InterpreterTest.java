package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InterpreterTest {

    private Interpreter interpreter;
    private Library library;

    @Test
    public void shouldDisplayTheMessageLibraryReturnedWhenIPassOneInInterpretMethod() {
        library = mock(Library.class);
        interpreter = new Interpreter(library);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        when(library.listBooks()).thenReturn("Book name");

        interpreter.interpret("1");

        assertEquals("Book name\n", outputStream.toString());
    }
}