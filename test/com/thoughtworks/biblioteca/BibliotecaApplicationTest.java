package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BibliotecaApplicationTest {

    private BibliotecaApplication bibliotecaApplication;
    private Options menuOptions;

    @Test
    public void shouldCallDisplayMethodOfDisplayConsoleWhenICallPrintWelcomeMessage() {
        menuOptions = new Options();
        bibliotecaApplication = new BibliotecaApplication(menuOptions);
        DisplayConsole displayConsole = mock(DisplayConsole.class);

        bibliotecaApplication.printWelcomeMessage(displayConsole);

        verify(displayConsole, times(1)).display();
    }

    @Test
    public void shouldReturnMeMenuOptionsWhenICallGetMenuOptions() {
        menuOptions = mock(Options.class);
        bibliotecaApplication = new BibliotecaApplication(menuOptions);

        bibliotecaApplication.getMenuOptions();

        verify(menuOptions, times(1)).getOptions();
    }

    @Test
    public void shouldPrintMenuOptionsWhenICallPrintMenuOptionsMethod() {
        menuOptions = new Options();
        bibliotecaApplication = new BibliotecaApplication(menuOptions);
        DisplayConsole displayConsole = mock(DisplayConsole.class);

        bibliotecaApplication.printMenuOptions(displayConsole);

        verify(displayConsole, times(1)).display();
    }
}