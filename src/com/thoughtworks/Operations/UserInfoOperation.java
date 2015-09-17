//this shows the information of currently logged in user.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.Display;
import com.thoughtworks.biblioteca.Library;

public class UserInfoOperation implements Operation{

    private Library library;

    public UserInfoOperation(Library library) {
        this.library = library;
    }

    @Override
    public void executeOperation() {
        String userInfo = library.getUserInfo();
        new Display(userInfo).display();
    }
}
