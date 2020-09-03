import java.util.Scanner;

public class Duke {
    public static Task[] tasks = new Task[100];
    static String horizontalLine = "____________________________________________________________\n";

    public static void main(String[] args) {
        printGreetings();
        boolean shouldAbort = false;

        while(!shouldAbort) {
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine().trim();
            String[] taskCommand = userInput.split(" ", 2);

            switch (taskCommand[0]) {
                case "bye":
                    String farewellMessage = "Bye. Hope to see you again soon!";
                    textBox(farewellMessage);
                    shouldAbort = true;
                    break;
                case "todo":
                    tasks[ToDo.taskNumber] = new ToDo(taskCommand[1]);
                    ToDo.addTask(tasks[ToDo.taskNumber]);
                    break;
                case "deadline":
                    String[] deadlineDescription = taskCommand[1].split("/");
                    tasks[Deadline.taskNumber] = new Deadline(deadlineDescription[0], deadlineDescription[1].substring(3));
                    Deadline.addTask(tasks[Deadline.taskNumber]);
                    break;
                case "event":
                    String[] eventDescription1 = taskCommand[1].split("/");
                    tasks[Event.taskNumber] = new Event(eventDescription1[0], eventDescription1[1].substring(3));
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
                    int index = Integer.parseInt(taskCommand[1]);
                    tasks[index - 1].markAsDone();
                    System.out.println(horizontalLine + "Nice!  I've marked this task as done:");
                    System.out.println("[" + tasks[index - 1].getStatusIcon() + "] " + tasks[index - 1].getDescription() + "\n" + horizontalLine);
                    break;
                default:
                    System.out.println(horizontalLine + "Sorry I don't get your command.\nTips: please use " +
                                        "keywords such as 'todo', 'deadline' or 'event'\n" + horizontalLine);
                    break;
            }

        }

    }

    public static void textBox(String text) {
        System.out.print(horizontalLine + text + System.lineSeparator() + horizontalLine);
    }

    private static void printGreetings() {
        String greet = "Hello! I'm Duke, your personal task assistant!\nWhat can I do for you today?";
        textBox(greet);
    }
}

