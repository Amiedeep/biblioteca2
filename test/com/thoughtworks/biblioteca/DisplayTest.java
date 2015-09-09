package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class DisplayTest {

    private Display display;

    @Test
    public void shouldDisplayTheMessageGivenToTheConstructorWhenICallDisplayMethod() {
        display = new Display("some    thing");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        display.display();

        assertEquals("some    thing\n", outputStream.toString());
    }
}