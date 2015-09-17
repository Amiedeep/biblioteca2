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
        user = new SimpleUser("111-2222", "abcd", "Amie Deep", "Aman@pathashala.com", 523743276527l);
    }

    @Test
    public void shouldReturnMeFalseWhenLibraryNumberAndPasswordAreNull() {
        assertFalse(user.logIn(null, null));
    }

    @Test
    public void shouldReturnMeFalseWhenLibraryNumberIsNull() {
        assertFalse(user.logIn(null, "something"));
    }

    @Test
    public void shouldReturnMeFalseWhenPasswordIsNull() {
        assertFalse(user.logIn("something", null));
    }

    @Test
    public void shouldReturnMeTrueWhenLibraryNumberAndPasswordMatch() {
        assertTrue(user.logIn("111-2222", "abcd"));
    }

    @Test
    public void shouldReturnMeFalseWhenLibraryNumberAndPasswordAreInvalid() {
        assertFalse(user.logIn("111-3333", "acd"));
    }

    @Test
    public void shouldReturnMeUserInfoWhenICallUserInfoMethod() {
        assertEquals("111-2222", user.userInfo());
    }

    @Test
    public void shouldReturnMeUserInfoForDisplayingWhenICallUserInfoToDisplayMethod() {
        String expected = String.format("%-40s %-40s %-40s %-40s\n", "111-2222", "Amie Deep", "Aman@pathashala.com", "523743276527");
        assertEquals(expected, user.userInfoToDisplay());
    }

    @Test
    public void shouldReturnMeUserHeadersWhenICallGetUserHeadersMethod() {
        String expected = String.format("%-40s %-40s %-40s %-40s\n", "library Number", "name", "email", "phoneNumber");
        assertEquals(expected, user.getUserHeaders());
    }
}