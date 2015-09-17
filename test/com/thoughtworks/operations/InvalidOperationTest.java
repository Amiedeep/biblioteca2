package com.thoughtworks.operations;

import com.thoughtworks.Operations.InvalidOperation;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class InvalidOperationTest {

    private InvalidOperation invalidOperation;

    @Test
    public void shouldShowTheInvalidMessageWhenICallExecuteOperationMethod() {
        invalidOperation = new InvalidOperation();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        invalidOperation.executeOperation();

        assertEquals("Select a valid option!\n", outputStream.toString());
    }
}