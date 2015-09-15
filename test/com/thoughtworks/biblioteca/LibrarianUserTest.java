package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class LibrarianUserTest {

    private User user;

    @Before
    public void setUp() {
        user = new LibrarianUser("222-1111", "dcba");
    }

    @Test
    public void shouldReturnMeFalseWhenUserNameAndPasswordAreNull() {
        assertFalse(user.logIn(null, null));
    }

    @Test
    public void shouldReturnMeFalseWhenUserNameIsNull() {
        assertFalse(user.logIn(null, "something"));
    }
}