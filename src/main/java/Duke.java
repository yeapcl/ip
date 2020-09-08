import java.util.Scanner;

public class Duke {
    private static final int MAX_TASKS = 100;
    private static final String horizontalLine = "____________________________________________________________\n";
    private static final Task[] tasks = new Task[MAX_TASKS];
//    private static String[] parsedInput = new String[2];

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

//    private static void checkInputValidity (String input) throws DukeException {
//        if (input == null || input.isEmpty() || input.isBlank() || Integer.parseInt(input) > Task.taskNumber ) {
//            throw new DukeException();
//        }
//    }

    private static void execute() throws DukeException {
        Scanner in = new Scanner(System.in);

        while(true) {
            String userInput = in.nextLine().trim();
            InputParser taskCommand = new InputParser(userInput);
            taskCommand.analyseTask();
            InputParser taskDescription = new InputParser(taskCommand.strings[1]);
//            String[] userInput = in.nextLine().trim().split(" ",2);
            switch (taskCommand.strings[0]) {
                case "bye":
                    String farewellMessage = "Bye. Hope to see you again soon!";
                    makeTextBorder(farewellMessage);
                    return;
                // Fallthrough
                case "todo":
//                        checkInputValidity(userInput[1]);
                    tasks[ToDo.taskNumber] = new ToDo(taskCommand.strings[1]);
                    ToDo.addTask(tasks[ToDo.taskNumber]);
                    break;
                case "deadline":
//                    String[] deadlineDetail = userInput[1].split("/", 2);
//                    checkInputValidity(deadlineDetail[1]);
                    taskDescription.analyseTaskDescription();
                    tasks[Deadline.taskNumber] = new Deadline(taskDescription.strings[0], taskDescription.strings[1].substring(3));
                    Deadline.addTask(tasks[Deadline.taskNumber]);
                    break;
                case "event":
//                    String[] eventDetail = userInput[1].split("/", 2);
                    taskDescription.analyseTaskDescription();
                    tasks[Event.taskNumber] = new Event(taskDescription.strings[0], taskDescription.strings[1].substring(3));
                    Event.addTask((tasks[Event.taskNumber]));
                    break;
                case "list":
                    System.out.println(horizontalLine + "Here are the tasks in your list: ");
//                    for (int i = 0; i < Task.taskNumber; i++) {
//                        System.out.println((i + 1) + "." + tasks[i]);
//                    }
//                    System.out.println(horizontalLine);
//                    System.out.println(tasks[0]);
//                    System.out.println(tasks[1]);
                    break;
                case "done":
//                    checkInputValidity(userInput[1]);
                    int doneIndex = Integer.parseInt(taskCommand.strings[1]);
                    tasks[doneIndex - 1].markAsDone();
                    System.out.println(horizontalLine + "Nice!  I've marked this task as done:");
                    System.out.println("[" + tasks[doneIndex - 1].getStatusIcon() + "] " + tasks[doneIndex - 1].getDescription() + "\n" + horizontalLine);
                    break;
                default:
                    throw new DukeException(("\n" + horizontalLine + "Sorry I don't get your command.\nTips: please use " +
                            "keywords such as 'todo', 'deadline' or 'event'\n" + horizontalLine));
            }

        }
    }


}


