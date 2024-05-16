package main.java.app;

import main.java.app.FilesOperation.PhoneBookFileOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages phone book entries
 */
public class Phonebook {

    PhoneBookFileOperation phoneBookFileOperation = new PhoneBookFileOperation();
    private List<PhoneBookEntry> entries;

    public Phonebook(List<String> dataFromPhoneBookFile)  {
        System.out.println(dataFromPhoneBookFile);

        this.initializePhoneBookWithDataFromFile(dataFromPhoneBookFile);
    }

    public  void initializePhoneBookWithDataFromFile(List<String> dataFromPhoneBookFile)  {

        if(!dataFromPhoneBookFile.isEmpty()){
            List<PhoneBookEntry> entries = this.phoneBookFileOperation.parseAndAddEntries(dataFromPhoneBookFile);

            System.out.println("Parse complete");
            entries.forEach(entry -> System.out.println(entry.toString()));

            this.setEntries(entries);
        }
    }


    public List<PhoneBookEntry> getEntries() {
        return this.entries;
    }

    public  void setEntries(List<PhoneBookEntry> entries) {
        this.entries = entries;
    }

    public void updateEntries(PhoneBookEntry entry){
        this.entries.add(entry);
    }


    public List<InterfacePhoneBookEntry> searchEntriesByName(String name) {
        List<InterfacePhoneBookEntry> results = new ArrayList<>();

        for (InterfacePhoneBookEntry entry : this.entries) {
            if (entry.getName().equalsIgnoreCase(name)) {
                results.add(entry);
            }
        }

        return results;
    }

    public void deleteEntryByName(String name) {
        this.entries.removeIf(entry -> entry.getName().equalsIgnoreCase(name));
    }

    public void deleteEntryByNameAndBirthday(String name, String birthday){
        this.entries
                .removeIf(item -> item.getName().equalsIgnoreCase(name.trim()) && item.getBirthday().equalsIgnoreCase(birthday.trim()));
    }
}
