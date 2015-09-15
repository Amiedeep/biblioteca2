package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

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

    @Test
    public void shouldReturnMeFalseWhenPasswordIsNull() {
        assertFalse(user.logIn("something", null));
    }

    @Test
    public void shouldReturnMeFalseWhenUserNameAndPasswordAreInvalid() {
        assertFalse(user.logIn("222-4444", "dcab"));
    }

    @Test
    public void shouldReturnMeTrueWhenUserNameAndPasswordMatch() {
        assertTrue(user.logIn("222-1111", "dcba"));
    }
}