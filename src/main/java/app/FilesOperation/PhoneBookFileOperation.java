package main.java.app.FilesOperation;

import main.java.app.PhoneBookEntry;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookFileOperation {

    public List<PhoneBookEntry> parseAndAddEntries(List<String> data) {
        List<PhoneBookEntry> entries = new ArrayList<>();

        // Temporary variables to hold field values
        String name = null;
        String birthday = null;
        String phone = null;
        String email = null;
        String address = null;

        for (String line : data) {
            if (line.trim().isEmpty()) {
                // If encountering an empty line, create a new PhoneBookEntry
                if (name != null && birthday != null && phone != null) {
                    PhoneBookEntry entry = new PhoneBookEntry(name, phone, birthday, address, email);
                    entries.add(entry);
                }
                // Reset temporary variables for the next entry
                name = null;
                birthday = null;
                phone = null;
                email = null;
                address = null;
            } else {
                // Split each line into key-value pair
                String[] parts = line.split("\\s+", 2);
                if (parts.length == 2) {
                    String key = parts[0].toLowerCase();
                    String value = parts[1].trim();
                    switch (key) {
                        case "name":
                            name = value;
                            break;
                        case "birthday":
                            birthday = value;
                            break;
                        case "phone":
                            phone = value;
                            break;
                        case "email":
                            email = value;
                            break;
                        case "address":
                            address = value;
                            break;
                    }
                }
            }
        }

        // Add the last entry if any fields are still populated
        if (name != null && birthday != null && phone != null) {
            PhoneBookEntry entry = new PhoneBookEntry(name, phone, birthday, address, email);
            entries.add(entry);
        }

        return entries;
    }
}
