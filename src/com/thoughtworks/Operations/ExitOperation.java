//This operation exits the system when called.
package com.thoughtworks.Operations;

import com.thoughtworks.biblioteca.Display;

public class ExitOperation implements Operation {

    @Override
    public void executeOperation() {
        System.exit(0);
    }
}
