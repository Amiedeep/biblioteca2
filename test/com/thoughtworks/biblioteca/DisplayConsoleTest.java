package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class DisplayConsoleTest {

    private DisplayConsole displayConsole;

    @Test
    public void shouldDisplayTheMessageGivenToTheConstructorWhenICallDisplayMethod() {
        displayConsole = new DisplayConsole("some    thing");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        displayConsole.display();

        assertEquals("some    thing\n", outputStream.toString());
    }
}