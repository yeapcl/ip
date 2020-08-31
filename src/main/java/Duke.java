import java.util.Scanner;

public class Duke {

    private static void printHorizontalLine() {
        System.out.println("____________________________________________________________");
    }

    private static void printGreet() {
        printHorizontalLine();
        System.out.println("Hello! I'm Duke");
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

        while(true) {
            String userInput;
            Scanner in = new Scanner(System.in);
            userInput = in.nextLine();
            printHorizontalLine();
            System.out.println(userInput);
            printHorizontalLine();

            if (userInput.equals("bye")) break;
        }

        System.out.println("Bye. Hope to see you again soon!");

    }
}
