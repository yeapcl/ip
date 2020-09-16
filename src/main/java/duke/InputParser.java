package duke;
import java.util.Scanner;

public class InputParser {
    protected String input;
    protected String command, commandDescription, taskDescription, slashDescription;


    public InputParser() throws DukeException {
        String[] strings = new String[2];
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine().trim();
        checkCommandValidity(userInput);
        strings = userInput.split(" ", 2);
        command = strings[0].toLowerCase();

        boolean isSlashExpected = userInput.startsWith("deadline") || userInput.startsWith("event");
        boolean isSingleWordCommand = userInput.startsWith("bye") || userInput.startsWith("list");

        if (isSlashExpected) {
            strings = userInput.split(" ", 2);
            strings = strings[1].split("/");
            taskDescription = strings[0];
            slashDescription = strings[1].substring(3);
        } else if (userInput.contains(" ")) {
            strings = userInput.split(" ", 2);
            commandDescription = strings[1];
        } else if (isSingleWordCommand) {
            command = userInput;
        } else {
            throw new DukeException(DukeException.ExceptionType.EMPTY_DESCRIPTION);
        }
    }

    private void checkCommandValidity(String string) throws DukeException {
        if (string == null || string.isEmpty() || string.isBlank()) {
            throw new DukeException(DukeException.ExceptionType.EMPTY_DESCRIPTION);
        }
    }
}
