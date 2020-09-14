package duke;
import java.util.Scanner;

import java.util.ArrayList;

public class InputParser {
    protected String input;
//    protected String[] strings = new String[2];
    protected String command, commandDetails, commandDescription, commandDescriptionDetails;


    public InputParser() throws DukeException {
        String[] strings = new String[2];
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine().trim();
        checkCommandValidity(userInput);
        strings = userInput.split(" ", 2);
        command = strings[0].toLowerCase();

        boolean isATask = userInput.startsWith("todo") || userInput.startsWith("deadline") || userInput.startsWith("event") || userInput.startsWith("done");

        if (!isATask) {
            command = userInput;
        } else if (userInput.contains(" ")) {
            strings = userInput.split(" ", 2);
            commandDetails = strings[1];
            System.out.println("string[0]: " + strings[0] + "; string[1]: " + strings[1]);
            strings = strings[1].split("/");
            commandDescription = strings[0];
            commandDescriptionDetails = strings[1].substring(3);
            System.out.println("commandDescriptionDetails here is:" + commandDescriptionDetails);
        } else {
            throw new DukeException(DukeException.ExceptionType.EMPTY_DESCRIPTION);
        }
    }

//    public void analyseTaskDescription() {
//        strings = input.split("/");
//    }

    private void checkCommandValidity(String description) throws DukeException {
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new DukeException(DukeException.ExceptionType.EMPTY_DESCRIPTION);
        }
    }
}
