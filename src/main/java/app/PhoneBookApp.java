package main.java.app;

import main.java.app.FilesOperation.FileHandler;
import main.java.app.FilesOperation.PhoneBookFileOperation;

/**
 * Main class to run the application
 */
public class PhoneBookApp {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

        Phonebook phonebook = new Phonebook(fileHandler.getFilesContentInList("src/resources/input/phonebook.txt"));

        InstructionParser instructionParser =
                new InstructionParser(fileHandler.getFilesContentInList("src/resources/input/instructions.txt"), phonebook);

        phonebook.getEntries().forEach(item -> System.out.println(item.toString()));
    }
}
