import javax.swing.text.html.parser.Parser;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static Task[] tasks = new Task[100];
    private static int taskNumber = 0;

    private static void printHorizontalLine() {
        System.out.println("____________________________________________________________");
    }

    private static void printGreet() {
        printHorizontalLine();
        System.out.println("Hello! I'm Vent.");
        System.out.println("What can I do for you?");
    }

    public static void main(String[] args) {
        printGreet();
//        ArrayList<Task> list = new ArrayList<>(); // quite difficult to implement
        String userInput;
        boolean exitProgram = false;

        while(!exitProgram) {
            Scanner in = new Scanner(System.in);
            userInput = in.nextLine().trim();
            String[] taskCommand = userInput.split(" ", 2); //split
            //test

//            taskCommand = userInput.substring(0, userInput.indexOf(' '));   // how to resolve if input has no space?
//            taskDescription = userInput.substring(userInput.indexOf(' ') + 1);

            switch (taskCommand[0]) {
                case "bye":
                    printHorizontalLine();
                    System.out.println("Bye. Hope to see you again soon!");
                    printHorizontalLine();
                    exitProgram = true;
                    break;
                case "todo":
                    printHorizontalLine();
                    tasks[taskNumber] = new ToDo(taskCommand[1]);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks[taskNumber]);
                    System.out.println("Now you have " + (taskNumber + 1) + " tasks in the list.");
                    printHorizontalLine();
                    taskNumber++;
                    break;
                case "deadline":
                    String[] deadlineDescription = taskCommand[1].split("/");
                    printHorizontalLine();
                    tasks[taskNumber] = new Deadline(deadlineDescription[0],deadlineDescription[1].substring(3));
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks[taskNumber]);
                    System.out.println("Now you have " + (taskNumber + 1) + " tasks in the list.");
                    printHorizontalLine();
                    taskNumber++;
                    break;
                case "event":
                    String[] eventDescription1 = taskCommand[1].split("/");
                    printHorizontalLine();
                    tasks[taskNumber] = new Event(eventDescription1[0],eventDescription1[1].substring(3));
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks[taskNumber]);
                    System.out.println("Now you have " + (taskNumber + 1) + " tasks in the list.");
                    printHorizontalLine();
                    taskNumber++;
                    break;
                case "list":
                    printHorizontalLine();
                    System.out.println("Here are the tasks in your list: ");
                    for (int i = 0; i < taskNumber; i++) {
                        System.out.println((i + 1) + "." + tasks[i]);
                    }
                    printHorizontalLine();
                    break;
                case "done":
                    int index = Integer.parseInt(taskCommand[1]);
                    tasks[index - 1].markAsDone();
//                    list.get(index - 1).markAsDone();
                    printHorizontalLine();
                    System.out.println("Nice!  I've marked this task as done:");
                    System.out.println("[" + tasks[index - 1].getStatusIcon() + "] " + tasks[index - 1].getDescription());
                    printHorizontalLine();
                    break;
                default:
                    break;
            }


//            } else if (userInput.startsWith("done")) {
//                int index = Integer.parseInt(userInput.substring(5));
//                if (index < 0 || index > list.size()) {
//                    System.out.println("Oops, index not found! Try again.");
//                    continue;
//                }
//
//            }
        }

    }
}
