package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author Ridwan Mustapha
 */
public class FileWriterClass {

    String directory = "/Users/ridwan/Documents";

    public void WriteFileToPath(String fileName, String question, String example) {
        try {
            String absolutePath = directory +File.separator+ fileName;
            FileWriter fileWriter = new FileWriter(absolutePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(fileName);
            printWriter.print(question);
            printWriter.print(example);
            printWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
