package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaApplicationTest {

    private BibliotecaApplication bibliotecaApplication;

    @Test
    public void shouldPrintWelcomeMessageOnTheScreenAndTheListOfBooks() {
        bibliotecaApplication = new BibliotecaApplication();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bibliotecaApplication.start("welcome");

        assertEquals("welcome\nList of books we have is: \n[scjp, head first java]\n", outContent.toString());
    }
}