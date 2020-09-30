package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class FindCommand extends Command {

    public FindCommand(String keyword) {
        super(keyword);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList tasksFound = new TaskList();
        for (Task t : tasks.getTaskList()) {
            if (t.getDescription().contains(input)) {
                tasksFound.addTask(t);
            }
        }
        ui.printFind(tasksFound, input);
    }
}
