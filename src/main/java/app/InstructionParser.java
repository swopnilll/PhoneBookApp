package main.java.app;

import main.java.app.FilesOperation.InstructionFileOperation;

import java.util.List;

/**
 * Parses instructions from file
 */

public class InstructionParser {

    InstructionFileOperation instructionFileOperation = new InstructionFileOperation();

    public InstructionParser(List<String> data, Phonebook phonebook) {
        instructionFileOperation.parseAndExecuteInstructions(data, phonebook);
    }
}
