package duke.parser;

import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.TodoCommand;

import duke.exception.DukeException;

/**
 * Parses the user's input.
 */
public class Parser {
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_DELETE = "delete";
    private static final String COMMAND_FIND = "find";
    private static final String COMMAND_BYE = "bye";

    /**
     * Returns a Command object based on user's string input.
     *
     * @param input user's string input.
     * @return a new Command object based on user's input.
     * @throws DukeException if user's input does not match any of the command.
     */
    public static Command parse(String input) throws DukeException {
        String[] parsedInputs = input.split(" ", 2);
        switch (parsedInputs[0]) {
        case COMMAND_TODO:
            checkTodoValidity(parsedInputs);
            return new TodoCommand(parsedInputs[1]);
        case COMMAND_DEADLINE:
            checkDeadlineValidity(parsedInputs);
            return new DeadlineCommand(parsedInputs[1]);
        case COMMAND_EVENT:
            checkEventValidity(parsedInputs);
            return new EventCommand(parsedInputs[1]);
        case COMMAND_LIST:
            return new ListCommand();
        case COMMAND_DONE:
            checkTaskIndexValidity(parsedInputs);
            return new DoneCommand(parsedInputs[1]);
        case COMMAND_DELETE:
            checkTaskIndexValidity(parsedInputs);
            return new DeleteCommand(parsedInputs[1]);
        case COMMAND_FIND:
            verifyFind(parsedInputs);
            return new FindCommand(parsedInputs[1]);
        case COMMAND_BYE:
            return new ByeCommand();
        default:
            throw new DukeException("Sorry! I don't know what that means :-(");
        }
    }

    /**
     * Checks the index's validity.
     *
     * @param input user's string input.
     * @throws DukeException if the index is not a number or within valid range.
     */
    private static void checkTaskIndexValidity(String[] input) throws DukeException {
        try {
            Integer.parseInt(input[1]);
        } catch (NumberFormatException e) {
            throw new DukeException("Please enter the task number you want to mark as done!");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("You've entered an invalid task number!");
        }
    }

    /**
     * Checks the validity of the description for todo.
     *
     * @param input user's string input.
     * @throws DukeException if the description for todo is an empty field.
     */
    private static void checkTodoValidity(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("There is no description in your todo command!");
        }
    }

    /**
     * Checks the validity of the description for deadline.
     *
     * @param input user's string input.
     * @throws DukeException if the description for deadline is an empty field.
     */
    private static void checkDeadlineValidity(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("There is no description in your deadline command!");
        } else if (!input[1].contains("/by")) {
            throw new DukeException("A deadline task requires a '/by' to indicate time frame!");
        }
        int byPosition = input[1].indexOf("/by");
        if (input[1].substring(0, byPosition).isBlank()) {
            throw new DukeException("There is no description in your deadline command!");
        } else if (input[1].substring(byPosition + 3).isBlank()) {
            throw new DukeException("Please indicate time frame!");
        }
    }

    /**
     * Checks the validity of the description for event.
     *
     * @param input user's string input.
     * @throws DukeException if the description for event is an empty field.
     */
    private static void checkEventValidity(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("There is no description in your event command!");
        } else if (!input[1].contains("/at")) {
            throw new DukeException("An event task requires an '/at' to indicate location!");
        }
        int atPosition = input[1].indexOf("/at");
        if (input[1].substring(0, atPosition).isBlank()) {
            throw new DukeException("There is no description in your event command!");
        } else if (input[1].substring(atPosition + 3).isBlank()) {
            throw new DukeException("An event task requires an '/at' to indicate location!");
        }
    }

    /**
     * Checks the validity of the KEYWORD for find.
     *
     * @param input user's string input.
     * @throws DukeException if the KEYWORD is an empty field.
     */
    private static void verifyFind(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("Search description is empty");
        }
    }

}
