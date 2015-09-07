package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ConsoleInputTest {

    private ConsoleInput consoleInput;

    @Before
    public void setUp() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Something".getBytes());
        System.setIn(inputStream);
    }

    @Test
    public void shouldTakeInputFromTheUserWhenICallGetInputMethod() {
        consoleInput = new ConsoleInput(new Scanner(System.in));

        assertEquals("Something", consoleInput.getInput());
    }
}