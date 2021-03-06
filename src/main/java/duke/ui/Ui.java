package duke.ui;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.ToDo;

import java.util.Scanner;

/**
 * Prints relevant messages to user based on user interaction.
 */
public class Ui {
    private static final String MESSAGE_LINE = "____________________________________________________________";
    private static final String MESSAGE_SAD_FACE = "\u2639";
    private static final String MESSAGE_GREETINGS = "\nHello! I'm Duke, your personal task assistant!\n"
            + "What can I do for you today?\n";

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Prints a horizontal divider line.
     */
    public void showLine() {
        System.out.println(MESSAGE_LINE);
    }

    /**
     * Reads user inputs.
     *
     * @return String the inputs provided by users, where leading and trailing spaces are trimmed.
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Prints welcome message.
     */
    public void showWelcome() {
        System.out.println(MESSAGE_LINE + MESSAGE_GREETINGS + MESSAGE_LINE);
    }

    /**
     * Prints out all tasks saved in the array list.
     *
     * @param taskList the array list to print.
     */
    public void printList(TaskList taskList) {
        if (taskList.getTotalTaskCount() > 0) {
            System.out.println("Here are the tasks in your list: ");
            int count = 1;
            for (Task t : taskList.getTaskList()) {
                System.out.println(count + ". " + t);
                count++;
            }
        } else {
            System.out.println("There is no task in the list! Consider adding one?");
        }
    }

    /**
     * Prints out the todo task given by the user.
     *
     * @param taskList the array list of tasks.
     * @param task the task to be added to the array list.
     */
    public void printToDo(TaskList taskList, ToDo task) {
        System.out.println("Got it! I've added the following to-do in the list:\n" + task);
        System.out.println("Now now have " + taskList.getTotalTaskCount() + " tasks in the list.");
    }

    /**
     * Prints out the deadline task given by the user.
     *
     * @param taskList the array list of tasks.
     * @param task the task to be added to the array list.
     */
    public void printDeadline(TaskList taskList, Deadline task) {
        System.out.println("Got it! I've added the following deadline in the list:\n" + task);
        System.out.println("Now now have " + taskList.getTotalTaskCount() + " tasks in the list.");
    }

    /**
     * Prints out the event task given by the user.
     *
     * @param taskList the array list of tasks.
     * @param task the task to be added to the array list.
     */
    public void printEvent(TaskList taskList, Event task) {
        System.out.println("Got it! I've added the following event in the list:\n" + task);
        System.out.println("Now now have " + taskList.getTotalTaskCount() + " tasks in the list.");
    }

    public void printDone(Task task) {
        System.out.println("Nice! I have marked this task as done:\n" + task);
    }

    /**
     * Prints out the task that has been deleted.
     *
     * @param taskList the array list of tasks.
     * @param task the task that has been deleted.
     */
    public void printDelete(TaskList taskList, Task task) {
        System.out.println("Noted. I have removed this task:\n" + task);
        System.out.println("Now you have " + taskList.getTotalTaskCount() + " tasks in this list.");
    }

    /**
     * Prints all result(s) that matches the search keyword.
     *
     * @param taskList the array list that contains the keyword.
     * @param keyword the word that the user searches.
     */
    public void printFind(TaskList taskList, String keyword) {
        if (taskList.getTotalTaskCount() > 0) {
            System.out.println("Here are the task(s) in your list that matches the keyword \"" + keyword + "\":");
            int count = 1;
            for (Task t : taskList.getTaskList()) {
                System.out.println(count + ". " + t);
                count++;
            }
        } else {
            System.out.println("No task contains the keyword \"" + keyword + "\".");
        }
    }

    /**
     * Prints farewell message.
     */
    public void showBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints error message.
     *
     * @param message the error message to be printed.
     */
    public void showError(String message) {
        System.out.println(MESSAGE_SAD_FACE + " OOPS!!! " + message);
    }
}
