package main.java.app.FilesOperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages file I/O operations
 */
public class FileHandler {
    /**
     * Function to get files content as a list
     *
     * @param file
     * @return Array list
     */
    public List<String> getFilesContentInList(String file) {
        List<String> fileContent = new ArrayList<>();

        try {
            // Check if the file exists
            Path filePath = Paths.get(file);

            if (!Files.exists(filePath)) {
                System.err.println("File not found: " + filePath);
                return fileContent; // Return empty list if file doesn't exist
            }

            // Read all lines from the file
            fileContent = Files.readAllLines(filePath);

            // Check if the file is empty
            if (fileContent.isEmpty()) {
                System.err.println("File is empty: " + filePath);
            }

        } catch (IOException e) {
            // Handle the exception gracefully
            System.err.println("Error reading file: " + file);
            e.printStackTrace(); // Print the stack trace for debugging

            // Optionally, log the exception or return a default value
        }

        return fileContent;
    }

    /**
     * Function to append content to file
     *
     * @param filepath
     * @param content
     */
    static void appendToFile(String filepath, String content) {
        try {
            // Append the content to the specified file
            Files.write(Paths.get(filepath), (content + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            // Handle specific exceptions and print a descriptive message
            System.err.println("Error appending to file: " + filepath);
            e.printStackTrace();
        }
    }
    
}
