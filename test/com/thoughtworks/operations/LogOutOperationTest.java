package com.thoughtworks.operations;

import com.thoughtworks.Operations.LogOutOperation;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class LogOutOperationTest {

    private LogOutOperation logOutOperation;

    @Test
    public void shouldShowTheInvalidMessageWhenICallExecuteOperationMethod() {
        logOutOperation = new LogOutOperation();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        logOutOperation.executeOperation();

        assertEquals("You are successfully log out\n", outputStream.toString());
    }
}