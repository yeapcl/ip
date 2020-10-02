package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.task.ToDo;
import duke.ui.Ui;

/**
 * Adds a todo to the task list.
 */
public class TodoCommand extends Command {

    public TodoCommand(String input) {
        super(input);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ToDo newTask = new ToDo(input);
        tasks.addTask(newTask);
        ui.printToDo(tasks, newTask);
        storage.write(tasks);
    }
}
