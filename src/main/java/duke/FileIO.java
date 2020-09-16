package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileIO {

    public FileIO() throws DukeException {
        try {
//            printFileContents();
            readFileContents();
        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
            throw new DukeException(DukeException.ExceptionType.FILE_NOT_FOUND);
        }
    }


//    private static void writeToFile(String filePath, String textToAdd) throws IOException {
//        FileWriter fw = new FileWriter(filePath);
//        fw.write(textToAdd);
//        fw.close();
//    }

    private static void printFileContents() throws FileNotFoundException {
        File f = new File("data/duke.txt"); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
    }

    private static void readFileContents() throws FileNotFoundException {
        File f = new File("data/duke.txt"); // create a File for the given file path
        ArrayList<String> list = new ArrayList<String>();
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
//        System.out.println(Arrays.toString(list.toArray()));

//        for (String list : kk) {
//            System.out.println(list.getName());
//        }

        System.out.println(list);
        System.out.println(list.toString());
        list.forEach(System.out::println);


    }




}
