package main.java.app;
import main.java.app.FilesOperation.FileHandler;

/**
 * Main class to run the application
 */
public class PhoneBookApp {
    public static void main(String[] args) {

//     Initializing the userInput class to take file path input from user.
       UserInput input=new UserInput();
       input.readFileNames();

       String phoneBookPath=input.getPhoneBookFilePath();
       String instructionPath=input.getInstructionFilePath();
       String finalPhoneBookFileName=input.getFinalPhonebookFileName();
       String finalResultFilename=input.getQueryResultFileName();


//       Checking if the file path is empty or not
        if(phoneBookPath.isEmpty() && instructionPath.isEmpty() && finalPhoneBookFileName.isEmpty() && finalResultFilename.isEmpty()){
            System.out.println("Error in reading file path");
            return;
        }

//        Initializing the filehandler class
        FileHandler fileHandler = new FileHandler();

//        Initilaizing phone book class
        Phonebook phonebook = new Phonebook(fileHandler.getFilesContentInList(phoneBookPath));

//        Initializing instruction parser class
        InstructionParser instructionParser = new InstructionParser(fileHandler.getFilesContentInList(instructionPath), phonebook,finalPhoneBookFileName,finalResultFilename);

//        Displaying the phonebook records.
        phonebook.getEntries().forEach(item -> System.out.println(item.toString()));
    }
}
