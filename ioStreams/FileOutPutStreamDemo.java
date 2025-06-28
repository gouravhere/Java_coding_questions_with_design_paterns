package ioStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Demonstrates file copying using FileInputStream and FileOutputStream.
 */
public class FileOutPutStreamDemo {
    public static void main(String[] args) {
        // Using try-with-resources to ensure streams are closed automatically
        try (FileInputStream fileInput = new FileInputStream("D:/PersonalProjects/ioStreams.txt");
             FileOutputStream fileOutput = new FileOutputStream("D:/PersonalProjects/newOutPutStream.txt")) {
            
            int data;
            // Read until end of file (-1 is returned when end of stream is reached)
            while ((data = fileInput.read()) != -1) {
                fileOutput.write(data);
                System.out.print((char) data);
            }
            System.out.println("\nFile copied successfully!");
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
