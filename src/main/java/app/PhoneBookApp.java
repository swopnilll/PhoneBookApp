package main.java.app;
import main.java.app.FilesOperation.FileHandler;
import utils.Constant;

/**
 * Main class to run the application
 */
public class PhoneBookApp {
    public static void main(String[] args) {

//     Initializing the userInput class to take file path input from user.
       UserInput input= new UserInput();
       input.readFileNames();

       String phoneBookPath=input.getPhoneBookFilePath();
       String instructionPath=input.getInstructionFilePath();
       String finalPhoneBookFileName=input.getFinalPhonebookFileName();
       String finalResultFilename=input.getQueryResultFileName();


//      Checking if the file path is empty or not
        if (phoneBookPath.isEmpty()) {
            System.err.println("\033[38;5;214m*** Warning: Phonebook file not provided. Using default file. ***\033[0m");
            phoneBookPath = Constant.DEFAULT_PHONEBOOK_PATH;
        }

        if (instructionPath.isEmpty()) {
            System.err.println("\033[38;5;214m*** Warning: Instruction file not provided. Using default file. ***\033[0m");
            instructionPath = Constant.DEFAULT_INSTRUCTION_PATH;
        }


//        Initializing the filehandler class
        FileHandler fileHandler = new FileHandler();

//       Initilaizing phone book class
        Phonebook phonebook = new Phonebook(fileHandler.getFilesContentInList(phoneBookPath));

//        Initializing instruction parser class
        InstructionParser instructionParser = new InstructionParser(fileHandler.getFilesContentInList(instructionPath), phonebook,finalPhoneBookFileName,finalResultFilename);

//        Displaying the phonebook records.
        phonebook.getEntries().forEach(item -> System.out.println(item.toString()));
    }
}
