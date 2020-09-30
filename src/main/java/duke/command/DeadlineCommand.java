package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeadlineCommand extends Command {

    public DeadlineCommand(String input) {
        super(input);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] parsedInputs = input.split(" /by ", 2);
        Deadline newTask = new Deadline(parsedInputs[0], parsedInputs[1]);
        tasks.addTask(newTask);
        ui.printDeadline(tasks, newTask);
        storage.write(tasks);
    }
}
