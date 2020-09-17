package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileIO {

    protected static ArrayList<String> list = new ArrayList<String>();
    protected static String taskType, isDoneString, taskDescription;
    protected static boolean isDone;
    protected static String[] taskDescriptionDetails;
    protected static final String DATA_PATH = "data/duke.txt";
    Path path = Paths.get("./data/");

    Duke duke = new Duke();

    public FileIO() throws DukeException {

        if (!Files.exists(path)) {
            throw new DukeException(DukeException.ExceptionType.FOLDER_NOT_FOUND);
        }

        try {
            readFileContents();
        } catch (FileNotFoundException e) {
            throw new DukeException(DukeException.ExceptionType.FILE_NOT_FOUND);
        }
    }

    private static void printFileContents() throws FileNotFoundException {
        File f = new File(DATA_PATH);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
    }

    private static void readFileContents() throws FileNotFoundException {
        File f = new File(DATA_PATH);


        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        System.out.println("duke.txt detected; Loading previous data...");
        System.out.println("Data loaded. You can access your previous saved tasks by using the command 'list'");
        System.out.println("____________________________________________________________\n");
        parseFromFile();
    }

    private static void parseFromFile() {

        for (String arr : list) {
            taskType = arr.substring(0,1);
            isDoneString = arr.substring(4, 5);
            isDone = isDoneString.equals("1");
            taskDescription = arr.substring(8);

            switch (taskType) {
            case "T":
                Duke.tasks.add(new ToDo(taskDescription, isDone));
                Task.getTaskTracker(Duke.tasks.get(Task.taskNumber), true);
                break;
            case "D":
                taskDescriptionDetails = taskDescription.split("\\|",2);
                Duke.tasks.add(new Deadline(taskDescriptionDetails[0].trim(), taskDescriptionDetails[1].trim(), isDone));
                Deadline.getTaskTracker(Duke.tasks.get(Deadline.taskNumber), true);
                break;
            case "E":
                taskDescriptionDetails = taskDescription.split("\\|",2);
                Duke.tasks.add(new Event(taskDescriptionDetails[0].trim(), taskDescriptionDetails[1].trim(), isDone));
                Deadline.getTaskTracker(Duke.tasks.get(Event.taskNumber), true);
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
            throw new DukeException(DukeException.ExceptionType.FOLDER_NOT_FOUND);
        }

        try {
            FileWriter fw = new FileWriter(DATA_PATH);

            for (Task readArrayList : Duke.tasks) {
                String taskType = readArrayList.toString().substring(1, 2);
                String checkIsDone, finalString, taskDetailBy, taskDetailAt;
                if (readArrayList.getStatusIcon().equals("\u2713")) {
                    checkIsDone = "1";
                } else {
                    checkIsDone = "0";
                }

                if (taskType.equals("D")) {
                    int count1 = readArrayList.toString().lastIndexOf("by: ") + 4;
                    int count2 = readArrayList.toString().indexOf(")");
                    taskDetailBy = readArrayList.toString().substring(count1, count2);
                    finalString = taskType + " | " + checkIsDone + " | " + readArrayList.getDescription() + " | " + taskDetailBy;
                } else if (taskType.equals("E")) {
                    int count1 = readArrayList.toString().lastIndexOf("at: ") + 4;
                    int count2 = readArrayList.toString().indexOf(")");
                    taskDetailAt = readArrayList.toString().substring(count1, count2);
                    finalString = taskType + " | " + checkIsDone + " | " + readArrayList.getDescription() + " | " + taskDetailAt;
                } else {
                    finalString = taskType + " | " + checkIsDone + " | " + readArrayList.getDescription();
                }

                fw.write(finalString + System.lineSeparator());
            }

            fw.close();

        } catch (IOException exception) {
            throw new DukeException(DukeException.ExceptionType.FOLDER_NOT_FOUND);
        }


    }
}
