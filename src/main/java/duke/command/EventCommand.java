package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Event;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Adds an event to the task list.
 */
public class EventCommand extends Command {

    public EventCommand(String input) {
        super(input);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] parsedInputs = input.split(" /at ", 2);
        Event newTask = new Event(parsedInputs[0], parsedInputs[1]);
        tasks.addTask(newTask);
        ui.printEvent(tasks, newTask);
        storage.write(tasks);
    }
}
