package duke.task;

public class Deadline extends Task {

    public String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        setTaskType("D");
    }

    /**
     * Returns the deadline detail of the task.
     * @return the deadline detail of the task.
     */
    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
