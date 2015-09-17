package com.thoughtworks.operations;

import com.thoughtworks.Operations.ExitOperation;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ExitOperationTest {

    private ExitOperation exitOperation;

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitTheSystemWhenExecuteOperationIsCalled() {
        exitOperation = new ExitOperation();

        exit.expectSystemExitWithStatus(0);

        exitOperation.executeOperation();
    }
}