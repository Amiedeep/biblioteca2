package com.thoughtworks.users;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SimpleUserTest {

    private User user;

    @Before
    public void setUp() {
        user = new SimpleUser("111-2222", "abcd");
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
    public void shouldReturnMeTrueWhenUserNameAndPasswordMatch() {
        assertTrue(user.logIn("111-2222", "abcd"));
    }

    @Test
    public void shouldReturnMeFalseWhenUserNameAndPasswordAreInvalid() {
        assertFalse(user.logIn("111-3333", "acd"));
    }

    @Test
    public void shouldReturnMeUserInfoWhenICallUserInfoMethod() {
        assertEquals("111-2222", user.userInfo());
    }
}