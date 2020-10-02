package duke.storage;

import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.ToDo;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages the loading and saving of data to or from a text file.
 */
public class Storage {
    private static final String MESSAGE_TICK_SYMBOL = "\u2713";
    private final String FILE_PATH;
    public static final int MAX_SIZE = 100;

    /**
     * Creates a new file if it does not exist.
     *
     * @throws DukeException if an I/O error has occurred.
     */
    public Storage(String FILE_PATH) throws DukeException {
        this.FILE_PATH = FILE_PATH;
        initialise();
    }

    /**
     * Initialises a file by checking path validity.
     *
     * @throws DukeException if an I/O error has occurred.
     */
    private void initialise() throws DukeException {
        File storageFile = new File(FILE_PATH);
        File storageFolder = new File(storageFile.getParent());
        if (storageFolder.exists() && storageFolder.isDirectory()) {
            System.out.println("Data folder found! Finding duke.txt...");
        } else {
            System.out.println("Data folder not found! Creating one...");
            if (!storageFolder.mkdir()) {
                throw new DukeException("Attempt to create a data folder failed.");
            }
        }
        try {
            if (storageFile.createNewFile()) {
                System.out.println("No existing duke.txt found! Creating one...");
            } else {
                System.out.println("Existing duke.txt found. Loading previously saved task list...");
            }
        } catch (IOException e) {
            throw new DukeException("Attempt to create duke.txt failed.");
        } finally {
            System.out.println("Previous task list loaded successfully");
        }
    }

    /**
     * Loads data from the text file to task arraylist.
     *
     * @throws DukeException if an I/O error has occurred.
     */
    public ArrayList<Task> load() throws DukeException {
        Scanner reader;
        try {
            reader = new Scanner(new File(FILE_PATH));
        } catch (FileNotFoundException e) {
            throw new DukeException("Attempt to read duke.txt failed.");
        }
        ArrayList<Task> tasks = new ArrayList<>(MAX_SIZE);
        while (reader.hasNextLine()) {
            loadTask(reader, tasks);
        }
        return tasks;
    }

    /**
     * Parses the saved tasks according to specified format in order to be loaded.
     *
     * @param reader reads user's string input.
     * @param storageTasks the task arraylist.
     * @throws DukeException if an I/O error has occurred.
     */
    private void loadTask(Scanner reader, ArrayList<Task> storageTasks) throws DukeException {
        Task task;
        String[] parsedLines = reader.nextLine().split("\\|");
        for (int i = 0; i < parsedLines.length; i++) {
            parsedLines[i] = parsedLines[i].trim();
        }
        switch (parsedLines[0]) {
        case "T":
            task = new ToDo(parsedLines[2]);
            break;
        case "D":
            task = new Deadline(parsedLines[2], parsedLines[3]);
            break;
        case "E":
            task = new Event(parsedLines[2], parsedLines[3]);
            break;
        default:
            throw new DukeException("Existing task list format is corrupted. Please check again.");
        }
        if (parsedLines[1].equals(MESSAGE_TICK_SYMBOL)) {  //
            task.markAsDone();
        }
        storageTasks.add(task);
    }

    /**
     * Writes data to the text file.
     *
     * @tasks Arraylist of task.
     * @throws DukeException if an I/O error has occurred.
     */
    public void write(TaskList taskList) throws DukeException {
        ArrayList<Task> tasks = taskList.getTaskList();
        try {
            FileWriter fw = new FileWriter(new File(FILE_PATH));
            writeTask(fw, tasks);
            fw.close();
        } catch (IOException e) {
            throw new DukeException("Attempt to write to duke.txt failed.");
        }
    }

    /**
     * Writes specific task details to the text file in given format.
     *
     * @param fw FileWriter object.
     * @tasks Arraylist of task.
     * @throws IOException if an I/O error has occurred.
     */
    private void writeTask(FileWriter fw, ArrayList<Task> tasks) throws IOException, DukeException {
        for (Task t : tasks) {
            fw.write(t.getTaskType() + " | " + t.getStatusIcon() + " | " + t.getDescription());
            if (t.getTaskType().equals("D")) {
                fw.write(" | " + ((Deadline) t).getBy());
            } else if (t.getTaskType().equals("E")) {
                fw.write(" | " + ((Event) t).getAt());
            }
            fw.append("\n");
        }
    }
}
