package duke.task;

public class Deadline extends Task {

    public String by;

    public Deadline(String description, String by){
        super(description);
        this.by = by;
        setTaskType("D");
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
