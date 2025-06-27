package ioStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    /**
     * Demonstrates the use of a FileInputStream to read the contents of a file.
     * This example uses a try-with-resources statement to ensure the stream is
     * closed automatically after it is used.
     *
     *
     */
    public static void main(String[] args) {
        // Using try-with-resources to ensure the stream is closed automatically
        try (FileInputStream file = new FileInputStream("D:/PersonalProjects/ioStreams.txt")) {
            int i;
            // Read until end of file (-1 is returned when end of stream is reached)
            while ((i = file.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
