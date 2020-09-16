package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.ArrayList;

import java.util.Scanner;


public class Duke {
    public static final String horizontalLine = "____________________________________________________________\n";
    public static final ArrayList<Task> tasks = new ArrayList<Task>();

//    public static final Task[] tasks = new Task[MAX_TASKS];


    public static void main(String[] args) throws DukeException {

        printGreetings();
        execute();
    }

    public static void makeTextBorder(String text) {
        System.out.print(horizontalLine + text + System.lineSeparator() + horizontalLine);
    }

    private static void printGreetings() {
        String greet = "Hello! I'm Duke, your personal task assistant!\nWhat can I do for you today?";
        makeTextBorder(greet);
    }

    private static void execute() throws DukeException {
//        ArrayList<Task> tasks = new ArrayList<Task>();
        FileIO io = new FileIO();

        while (true) {
            InputParser parsedInput = new InputParser();

            try {
                switch (parsedInput.command) {
                case "bye":
                    String farewellMessage = "Bye. Hope to see you again soon!";
                    makeTextBorder(farewellMessage);
                    return;
                    // Fallthrough
                case "todo":
                    tasks.add(new ToDo(parsedInput.commandDescription));
                    Task.getTaskTracker(tasks.get(Task.taskNumber));
                    break;
                case "deadline":
                    tasks.add(new Deadline(parsedInput.taskDescription, parsedInput.slashDescription));
                    Deadline.getTaskTracker(tasks.get(Deadline.taskNumber));
                    break;
                case "event":
                    tasks.add(new Event(parsedInput.taskDescription, parsedInput.slashDescription));
                    Event.getTaskTracker(tasks.get(Event.taskNumber));
                    break;
                case "list":
                    System.out.println(horizontalLine + "Here are the tasks in your list: ");
                    int i = 1;
                    for (Task str : tasks) {
                        System.out.println(i + "." + str);
                        i++;
                    }
                    System.out.println(horizontalLine);
                    break;
                case "done":
                    int doneIndex = Integer.parseInt(parsedInput.commandDescription);
                    if (doneIndex > tasks.size() || doneIndex < 0) {
                        throw new DukeException(DukeException.ExceptionType.INDEX_OUT_OF_BOUND);
                    } else {
                        tasks.get(doneIndex - 1).markAsDone();
                    }
                    System.out.println(horizontalLine + "Nice! I've marked this task as done:");
                    System.out.println("[" + tasks.get(doneIndex - 1).getStatusIcon() + "] " + tasks.get(doneIndex - 1).getDescription() + "\n" + horizontalLine);
                    break;
                case "delete":
                    int deleteIndex = Integer.parseInt(parsedInput.commandDescription) - 1;
                    if (deleteIndex > tasks.size() || deleteIndex < 0) {
                        throw new DukeException(DukeException.ExceptionType.INDEX_OUT_OF_BOUND);
                    } else {
                        System.out.println(horizontalLine + "Noted. I have removed this task:\n" + tasks.get(deleteIndex) + "\n");
                        tasks.remove(deleteIndex);
                        Task.taskNumber--;
                        System.out.println("Now you have " + tasks.size() + " tasks in the list." + horizontalLine);
                    }
                    break;
                default:
                    throw new DukeException(DukeException.ExceptionType.INVALID_INPUT);
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                throw new DukeException(DukeException.ExceptionType.INDEX_OUT_OF_BOUND);
            }

        }
    }
}


