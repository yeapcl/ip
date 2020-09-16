package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class FileIO {

    protected static ArrayList<String> list = new ArrayList<String>();
    protected static String taskType, isDoneString, taskDescription;
    protected static boolean isDone;
    protected static String[] taskDescriptionDetails;
    protected static final String DATA_PATH = "data/duke.txt";

    Duke duke = new Duke();

    public FileIO() throws DukeException {
        try {
            readFileContents();
        } catch (FileNotFoundException e) {
            throw new DukeException(DukeException.ExceptionType.FILE_NOT_FOUND);
        }
    }

    private static void printFileContents() throws FileNotFoundException {
        File f = new File(DATA_PATH); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
    }

    private static void readFileContents() throws FileNotFoundException {
        File f = new File("data/duke.txt"); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        parseFromFile();
    }

    private static void parseFromFile() {
        System.out.println("Loading from file...");

        for (String arr : list) {
            taskType = arr.substring(0,1);
            isDoneString = arr.substring(4, 5);
            isDone = isDoneString.equals("1");
            taskDescription = arr.substring(8);

            switch (taskType) {
            case "T":
                Duke.tasks.add(new ToDo(taskDescription, isDone));
                Task.getTaskTracker(Duke.tasks.get(Task.taskNumber));
                break;
            case "D":
                taskDescriptionDetails = taskDescription.split("\\|",2);
                Duke.tasks.add(new Deadline(taskDescriptionDetails[0].trim(), taskDescriptionDetails[1].trim(), isDone));
                Deadline.getTaskTracker(Duke.tasks.get(Deadline.taskNumber));
                break;
            case "E":
                taskDescriptionDetails = taskDescription.split("\\|",2);
                Duke.tasks.add(new Event(taskDescriptionDetails[0].trim(), taskDescriptionDetails[1].trim(), isDone));
                Deadline.getTaskTracker(Duke.tasks.get(Event.taskNumber));
                break;
            }
        }
    }

    public static void saveTasksList() throws DukeException {
        File saveFile = new File(DATA_PATH);
        boolean fileExists = saveFile.exists();

        try {
            if (!fileExists) {
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            }

        } catch (IOException exception) {
            throw new DukeException(DukeException.ExceptionType.CANNOT_CREATE_DIRECTORIES);
        }

        try {
            FileWriter saveFileWriter = new FileWriter(DATA_PATH);

            saveFileWriter.close();
        } catch (IOException exception) {
            throw new DukeException(DukeException.ExceptionType.CANNOT_CREATE_DIRECTORIES);
        }
    }
}
