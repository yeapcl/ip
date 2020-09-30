package duke.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
        setTaskType("T");
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
