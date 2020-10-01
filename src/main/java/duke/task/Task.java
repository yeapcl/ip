package duke.task;

/**
 * Provides the blueprint for a Task object
 */
public abstract class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;

    /**
     * Constructor to initialise a new Task object, and mark it as undone by default.
     *
     * @param description the description of a particular task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Set the task type based on 'todo', 'deadline' and 'event'
     *
     * @param taskType the type of task
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /**
     * To retrieve a particular task's description
     *
     * @return the description of the task
     */
    public String getDescription() {
        return description;
    }

    public String getTaskType() {
        return taskType;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

}
