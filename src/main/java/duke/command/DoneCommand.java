package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Marks a task in the task list as done.
 */
public class DoneCommand extends Command {

    public DoneCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int index = Integer.parseInt(input);
        Task completedTask = tasks.getTask(index);
        if (!completedTask.isDone()) {
            completedTask.markAsDone();
        } else {
            throw new DukeException("That task was already done!");
        }
        ui.printDone(completedTask);
        storage.write(tasks);
    }
}
