package main.java.app;

import utils.Constant;

import java.util.Scanner;

public class UserInput {
    private String instructionFilePath;
    private String phoneBookFilePath;
    private String finalPhonebookFileName;
    private String queryResultFileName;

    /**
     * Function to read file path and name.
     */
    public void readFileNames() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the phonebook.txt file:");
        phoneBookFilePath = sc.nextLine().trim();

        System.out.println("Please enter the instructions.txt file path. In order to avoid error add inside src folder. eg src/instructions.txt:");
        instructionFilePath = sc.nextLine().trim();

        System.out.println("Enter the final phone book file name and add it in the root folder:");
        finalPhonebookFileName = sc.nextLine().trim();
        if (finalPhonebookFileName.isEmpty()) {
            finalPhonebookFileName = Constant.DEFAULT_OUTPUT_FILE;
        }

        System.out.println("Enter the final results file name and add it in the root folder:");
        queryResultFileName = sc.nextLine().trim();
        if (queryResultFileName.isEmpty()) {
            queryResultFileName = Constant.DEFAULT_QUERY_RESULT_FILE;
        }
    }

    public String getPhoneBookFilePath() {
        return phoneBookFilePath;
    }

    public String getFinalPhonebookFileName() {
        return finalPhonebookFileName;
    }

    public String getQueryResultFileName() {
        return queryResultFileName;
    }

    public String getInstructionFilePath() {
        return instructionFilePath;
    }
}