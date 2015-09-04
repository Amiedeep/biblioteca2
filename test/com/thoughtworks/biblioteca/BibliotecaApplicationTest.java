package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaApplicationTest {

    private BibliotecaApplication bibliotecaApplication;

    @Test
    public void shouldPrintWelcomeMessageOnTheScreen() {
        bibliotecaApplication = new BibliotecaApplication();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bibliotecaApplication.printWelcomeMessage("welcome");

        assertEquals("welcome\n", outContent.toString());
    }
}