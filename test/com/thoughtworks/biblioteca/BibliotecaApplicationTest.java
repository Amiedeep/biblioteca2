package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BibliotecaApplicationTest {

    private BibliotecaApplication bibliotecaApplication;

    @Test
    public void shouldCallDisplayMethodOfDisplayConsoleWhenICallPrintWelcomeMessage() {
        bibliotecaApplication = new BibliotecaApplication();
        DisplayConsole displayConsole = mock(DisplayConsole.class);

        bibliotecaApplication.printWelcomeMessage(displayConsole);

        verify(displayConsole, times(1)).display();
    }
}