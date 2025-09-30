
/*
 * Internship Task: File Operations in Java
 * Author: [Your Name]
 * 
 * This program demonstrates how to:
 * 1. Write data to a file
 * 2. Read data from a file
 * 3. Modify (append/update) data in a file
 *
 * Deliverable: A self-contained script with clear documentation.
 */

import java.io.*;

public class FileOperationsDemo {

    // Path to the file
    private static final String FILE_NAME = "example.txt";

    public static void main(String[] args) {
        try {
            // 1. Write initial content to file
            writeToFile("Hello, this is the first line.\n");

            // 2. Read and display file content
            System.out.println("File Content After Writing:");
            readFromFile();

            // 3. Modify file by appending more content
            appendToFile("This line was appended later.\n");

            // 4. Read and display updated file content
            System.out.println("\nFile Content After Appending:");
            readFromFile();

            // 5. Modify file by replacing content
            overwriteFile("File content has been overwritten!\n");

            // 6. Read and display final file content
            System.out.println("\nFile Content After Overwriting:");
            readFromFile();

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to write new content to file (overwrites file if it exists)
    private static void writeToFile(String content) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(content);
        }
    }

    // Method to read file content
    private static void readFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    // Method to append content to an existing file
    private static void appendToFile(String content) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // true = append mode
            writer.write(content);
        }
    }

    // Method to overwrite file with new content
    private static void overwriteFile(String content) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) { // false = overwrite
            writer.write(content);
        }
    }
}
