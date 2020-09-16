package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;
import java.util.Scanner;

public class Duke {
    private static final int MAX_TASKS = 100;
    public static final String horizontalLine = "____________________________________________________________\n";
    public static final Task[] tasks = new Task[MAX_TASKS];

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
        FileIO io = new FileIO();

        while(true) {
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine().trim();
            InputParser taskCommand = new InputParser(userInput);

            switch (taskCommand.strings[0]) {
                case "bye":
                    String farewellMessage = "Bye. Hope to see you again soon!";
                    makeTextBorder(farewellMessage);
                    return;
                // Fallthrough
            case "todo":
                    tasks[ToDo.taskNumber] = new ToDo(taskCommand.strings[1]);
                    ToDo.addTask(tasks[ToDo.taskNumber]);
                    break;
                case "deadline":
                    taskCommand.analyseTaskDescription();
                    tasks[Deadline.taskNumber] = new Deadline(taskCommand.strings[0], taskCommand.strings[1].substring(3));
                    Deadline.addTask(tasks[Deadline.taskNumber]);
                    break;
                case "event":
                    taskCommand.analyseTaskDescription();
                    tasks[Event.taskNumber] = new Event(taskCommand.strings[0], taskCommand.strings[1].substring(3));
                    Event.addTask((tasks[Event.taskNumber]));
                    break;
                case "list":
                    System.out.println(horizontalLine + "Here are the tasks in your list: ");
                    for (int i = 0; i < Task.taskNumber; i++) {
                        System.out.println((i + 1) + "." + tasks[i]);
                    }
                    System.out.println(horizontalLine);
                    break;
                case "done":
                    int doneIndex = Integer.parseInt(taskCommand.strings[1]);
                    tasks[doneIndex - 1].markAsDone();
                    System.out.println(horizontalLine + "Nice!  I've marked this task as done:");
                    System.out.println("[" + tasks[doneIndex - 1].getStatusIcon() + "] " + tasks[doneIndex - 1].getDescription() + "\n" + horizontalLine);
                    break;
                default:
                    throw new DukeException(DukeException.ExceptionType.INVALID_INPUT);
            }

        }
    }
}


