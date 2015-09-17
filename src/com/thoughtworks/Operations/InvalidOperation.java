//This will show the invalid message when user choose invalid option.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.Display;

public class InvalidOperation implements Operation {

    @Override
    public void executeOperation() {
        new Display("Select a valid option!").display();
    }
}
