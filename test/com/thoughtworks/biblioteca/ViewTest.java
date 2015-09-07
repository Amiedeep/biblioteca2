package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class ViewTest {

    private View view;

    @Test
    public void shouldDisplayTheMessageGivenToTheConstructorWhenICallDisplayMethod() {
        view = new View("some    thing");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        view.display();

        assertEquals("some    thing\n", outputStream.toString());
    }
}