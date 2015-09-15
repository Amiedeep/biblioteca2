package com.thoughtworks.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GuestUserTest {

    private User user;

    @Test
    public void shouldReturnMeTrueWhenIAskLoginForGuestUser() {
        user = new GuestUser();

        assertTrue(user.logIn("some username", "some password"));
    }
}