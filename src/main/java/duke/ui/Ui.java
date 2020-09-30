package duke.ui;

import duke.task.*;

import java.util.Scanner;

public class Ui {
    private static final String MESSAGE_LINE = "____________________________________________________________";
    private static final String MESSAGE_GREETINGS = "\nHello! I'm Duke, your personal task assistant!\n" +
            "What can I do for you today?\n";
    private final Scanner scanner = new Scanner(System.in);

    public void showLine() {
        System.out.println(MESSAGE_LINE);
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showWelcome() {
        System.out.println(MESSAGE_LINE + MESSAGE_GREETINGS + MESSAGE_LINE);
    }

    public void printList(TaskList taskList) {
        if (taskList.getTotalTaskCount() > 0) {
            System.out.println("Here are the tasks in your list: ");
            int i = 1;
            for (Task t : taskList.getTaskList()) {
                System.out.println(i + ". " + t);
                i++;
            }
        } else {
            System.out.println("There is no task in the list! Consider adding one?");
        }
    }

    public void printToDo(TaskList taskList, ToDo task) {
        System.out.println("Got it! I've added the following to-do in the list:\n" + task);
        System.out.println("Now now have " + taskList.getTotalTaskCount() + " tasks in the list.");
    }

    public void printDeadline(TaskList taskList, Deadline task) {
        System.out.println("Got it! I've added the following deadline in the list:\n" + task);
        System.out.println("Now now have " + taskList.getTotalTaskCount() + " tasks in the list.");
    }

    public void printEvent(TaskList taskList, Event task) {
        System.out.println("Got it! I've added the following event in the list:\n" + task);
        System.out.println("Now now have " + taskList.getTotalTaskCount() + " tasks in the list.");
    }

    public void printDone(Task task) {
        System.out.println("Nice! I have marked this task as done:\n" + task);
    }

    public void printDelete(TaskList taskList, Task task) {
        System.out.println("Noted. I have removed this task:\n" + task);
        System.out.println("Now you have " + taskList.getTotalTaskCount() + " tasks in this list.");
    }

    public void printFind(TaskList taskList, String key) {
        if (taskList.getTotalTaskCount() > 0) {
            System.out.println("Thwis are the tasks that match \"" + key + "\":");
            int i = 1;
            for (Task t : taskList.getTaskList()) {
                System.out.println(i + ". " + t);
                i++;
            }
        } else {
            System.out.println("Thwere is no task that matches \"" + key + "\".");
        }
    }

    public void showBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showError(String message) {
        System.out.println("\u2639 OOPS!!! " + message);
    }
}
