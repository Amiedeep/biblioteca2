//This class has option list to choose from for user
package com.thoughtworks.options;

import java.util.List;

public abstract class Options {

    public List<String> options;

    public Options(List<String> options) {
        this.options = options;
    }

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
