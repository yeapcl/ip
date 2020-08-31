import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

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
        ArrayList<Task> list = new ArrayList<>();
        String userInput;

        while(true) {
            Scanner in = new Scanner(System.in);
            userInput = in.nextLine();

            if (userInput.equals("bye")) {
                printHorizontalLine();
                System.out.println("Bye. Hope to see you again soon!");
                printHorizontalLine();
                break;
            } else if (userInput.equals("list")) {
                printHorizontalLine();
                System.out.println("Here are the tasks in your list: ");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println( (i+1) + ".[" + list.get(i).getStatusIcon() + "] " + list.get(i).getDescription());
                }
                printHorizontalLine();
            } else if (userInput.startsWith("done")) {
                int index = Integer.parseInt(userInput.substring(5));
                if (index < 0 || index > list.size()) {
                    System.out.println("Oops, index not found! Try again.");
                    continue;
                }
                list.get(index - 1).markAsDone();
                printHorizontalLine();
                System.out.println("Nice!  I've marked this task as done:");
                System.out.println("[" + list.get(index - 1).getStatusIcon() + "] " + list.get(index - 1).getDescription());
                printHorizontalLine();
            } else {
                Task t = new Task(userInput);
                list.add(t);
                printHorizontalLine();
                System.out.println("added: " + userInput);
                printHorizontalLine();
            }
        }



    }
}
