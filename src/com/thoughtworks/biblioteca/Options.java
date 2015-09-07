//This class has option list to choose from for user
package com.thoughtworks.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Options {

    private final List<String> options = Arrays.asList("List Books", "Quit");

    public String getOptions() {
        String listOfOptions = "Please choose one option: \n";
        int index = 1;
        for(String option : options) {
            listOfOptions += index+": "+option+"\n";
            index++;
        }
        return listOfOptions;
    }
}
