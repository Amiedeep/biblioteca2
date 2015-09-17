package com.thoughtworks.operations;

import com.thoughtworks.Operations.UserInfoOperation;
import com.thoughtworks.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class UserInfoOperationTest {

    private UserInfoOperation userInfoOperation;
    private Library library;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        library = mock(Library.class);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldDisplayTheMessageLibraryReturnedWhenICallExecuteOperationMethod() {
        userInfoOperation = new UserInfoOperation(library);

        when(library.getUserInfo()).thenReturn("user info");

        userInfoOperation.executeOperation();

        assertEquals("user info\n", outputStream.toString());

        verify(library, times(1)).getUserInfo();
    }
}