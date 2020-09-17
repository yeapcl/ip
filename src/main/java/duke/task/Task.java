package duke.task;
import duke.Duke;

public class Task {
    protected String description;
    protected boolean isDone;
    public static int taskNumber = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public static void getTaskTracker(Task item) {
        Duke.makeTextBorder("Got it. I've added this task:\n" + item.toString() + "\nNow you have " + (taskNumber + 1) + " tasks in the list.");
        taskNumber++;
    }

    public static void getTaskTracker(Task item, boolean isFromFile) {
        taskNumber++;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }
}