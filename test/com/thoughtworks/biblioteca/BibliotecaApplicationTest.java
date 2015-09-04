package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @Test
    public void shouldCallPrintWelcomeMessageWhenICallStart() {
        bibliotecaApplication = spy(new BibliotecaApplication());

        bibliotecaApplication.start();

        verify(bibliotecaApplication, times(1)).printWelcomeMessage("Hey! Welcome to biblioteca");
    }

    @Test
    public void shouldPrintListOfBooksOnTheScreen() {
        List<String> books = Arrays.asList("first book", "second book");
        bibliotecaApplication = new BibliotecaApplication();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bibliotecaApplication.printBooks(books);

        assertEquals("[first book, second book]\n", outContent.toString());
    }
}