package main.java.app.FilesOperation;

import main.java.app.PhoneBookEntry;
import main.java.app.Phonebook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstructionFileOperation {

    public static String getCommandVerb(String instructions) {
        return instructions.split(" ")[0].trim().toLowerCase();
    }

    public static String getCommandInstruction(String instructions) {
        String[] parts = instructions.split(" ", 2);

        return parts.length > 1 ? parts[1].trim() : "";
    }

    public static Boolean validateIfEntryExists(PhoneBookEntry person, List<PhoneBookEntry> phoneBookDatabase){
        return phoneBookDatabase.stream().anyMatch(item ->
                item.getName().equals(person.getName()) && item.getBirthday().equals(person.getBirthday())
        );
    }

    public static void updateExistingEntry(PhoneBookEntry person, Phonebook phonebook){
        PhoneBookEntry existingPerson = phonebook.getEntries().stream().filter(entry ->
                entry.getName().equals(person.getName()) && entry.getBirthday().equals(person.getBirthday())
        ).toList().get(0);

        if (person.getAddress() != null && !person.getAddress().isEmpty()) {
            existingPerson.setAddress(person.getAddress());
        }

        if (person.getPhoneNumber() != null && !person.getPhoneNumber().isEmpty()) {
            existingPerson.setPhoneNumber(person.getPhoneNumber());
        }

        if (person.getEmail() != null && !person.getEmail().isEmpty()) {
            existingPerson.setEmail(person.getEmail());
        }
    }

    public static void addPhoneBook(String newEntryDetails, Phonebook phonebook){
        String[] keyValue = newEntryDetails.split(";");

        PhoneBookEntry phoneBookEntry = new PhoneBookEntry();

        for(String item: keyValue){
            String trimmedItem = item.trim();

            String fieldName = trimmedItem.substring(0, trimmedItem.indexOf(' '));

            String value = trimmedItem.substring(trimmedItem.indexOf(' ')).trim();

            switch (fieldName) {
                case "name":
                    phoneBookEntry.setName(value);
                    break;
                case "birthday":
                    phoneBookEntry.setBirthday(value);
                    break;
                case "phone":
                    phoneBookEntry.setPhoneNumber(value);
                    break;
                case "address":
                    phoneBookEntry.setAddress(value);
                    break;

                case "email":
                    phoneBookEntry.setEmail(value);
                    break;
            }

        }

        if(validateIfEntryExists(phoneBookEntry, phonebook.getEntries())){
            System.out.println("Entry Already exists for: " +phoneBookEntry.toString());
            System.out.println("Updating existing entry");
            updateExistingEntry(phoneBookEntry, phonebook);
        }else{
            phonebook.updateEntries(phoneBookEntry);
        }

    }

    public static void deletePhoneBookEntry(Phonebook phonebook, String detail){
        String[] keyValue = detail.split(";");

        String name;
        String birthday;

        if(keyValue.length == 2){
             name = keyValue[0].trim();
             birthday = keyValue[1].trim();

            phonebook.deleteEntryByNameAndBirthday(name.trim(), birthday.trim());
        }else{
            phonebook.deleteEntryByName(detail.trim());
        }

    }

    public  void operateCommands(String instructions, Phonebook phonebook) {
        String commandVerb = getCommandVerb(instructions);
        String command = getCommandInstruction(instructions);

        switch (commandVerb) {
            case "add":
                addPhoneBook(command, phonebook);
                break;
            case "delete":
                deletePhoneBookEntry(phonebook, command);
                break;
            case "query":
                System.out.println("Query Command Called");
                this.queryCommandHandler(phonebook, command);
                break;
            case "save":
                System.out.println("Save Command Called");
                break;
            default:
                System.out.println("Invalid Command");
        }
    }

    public void parseAndExecuteInstructions(List<String> data, Phonebook phonebook){
        for(String item : data){
            if(!item.isEmpty()) {
                operateCommands(item, phonebook);
            }
        }
    }

    public void queryCommandHandler(Phonebook phonebook, String command){
        String field = getCommandVerb(command);
        String value = getCommandInstruction(command);

        List<PhoneBookEntry> queryOutcome = new ArrayList<>();

        switch (field){
            case "name":
                queryOutcome = phonebook.searchEntriesByName(value);
                break;

            case "birthday":
                queryOutcome = phonebook.searchEntriesByBirthday(value);
                break;

            case "phone":
                queryOutcome = phonebook.searchEntriesByPhone(value);
                break;

            case "email":
                queryOutcome = phonebook.searchEntriesByEmail(value);
                break;

            case "address":
                queryOutcome = phonebook.searchEntriesByAddress(value);
                break;

            default:
                queryOutcome = null;
        }

        if(queryOutcome != null){
            writePersonsToFile("result.txt", queryOutcome);
        }

    }

    public static void writePersonsToFile(String filepath, List<PhoneBookEntry> persons)  {
        // Convert each Person object to its string representation and append to the file
        for (PhoneBookEntry person : persons) {
            String personString = person.toString(); // or use JSON library to convert to JSON format
            FileHandler.appendToFile(filepath, personString);
        }
    }
}
