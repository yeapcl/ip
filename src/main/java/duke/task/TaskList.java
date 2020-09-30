package duke.task;

import duke.exception.DukeException;

import java.util.ArrayList;

public class TaskList {

    public static final int MAX_SIZE = 100;
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>(MAX_SIZE);
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        tasks.remove(index - 1);
    }

    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    public Task getTask(int index) throws DukeException {
        try {
            return tasks.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Invalid task number! Type 'list' to get an overview of your tasks.");
        }
    }

    public int getTotalTaskCount() {
        return tasks.size();
    }
}
