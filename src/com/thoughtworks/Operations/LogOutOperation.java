//This will logout the customer and present login options again.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.Display;

public class LogOutOperation implements Operation {

    @Override
    public void executeOperation() {
        new Display("You are successfully log out").display();
    }
}
