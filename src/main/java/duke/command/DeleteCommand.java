package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeleteCommand extends Command {

    public DeleteCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int index = Integer.parseInt(input);
        Task removedTask = tasks.getTask(index);
        tasks.deleteTask(index);
        ui.printDelete(tasks, removedTask);
        storage.write(tasks);
    }
}
