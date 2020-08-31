import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class Duke {

    private static void printHorizontalLine() {
        System.out.println("____________________________________________________________");
    }

    private static void printGreet() {
        printHorizontalLine();
        System.out.println("Hello! I'm Vent");
        System.out.println("What can I do for you?");
    }



    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        printGreet();
        ArrayList<String> list = new ArrayList<String>();
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
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i+1 + ". " + list.get(i));
                }
                printHorizontalLine();
            } else {
                list.add(userInput);
                printHorizontalLine();
                System.out.println("added: " + userInput);
                printHorizontalLine();
            }
        }



    }
}
