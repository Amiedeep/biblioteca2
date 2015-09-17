package com.thoughtworks.interpreters;

import com.thoughtworks.Operations.Operation;

public interface Interpreter {
    Operation interpret(String input);
}
