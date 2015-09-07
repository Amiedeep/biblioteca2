package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BibliotecaApplicationTest {

    private BibliotecaApplication bibliotecaApplication;
    private View welcomeView;
    private View displayView;

    @Test
    public void shouldCallDisplayMethodOfDisplayConsoleWhenICallPrintWelcomeMessage() {
        welcomeView = mock(View.class);
        displayView = mock(View.class);
        bibliotecaApplication = new BibliotecaApplication(welcomeView, displayView);

        bibliotecaApplication.start();

        verify(welcomeView, times(1)).display();
        verify(displayView, times(1)).display();
    }
}