package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    public static Contact crateContact(String name, String phone) {
        return new Contact(name, phone);
    }

    private final Map<String, List<Contact>> storage = new HashMap<>();

    public boolean addGroup(String groupName) {
        if (storage.containsKey(groupName)) return false;
        storage.put(groupName, new ArrayList<>());
        return true;
    }

    public boolean addContactToGroup(Contact contact, String... groupNames) {
        for (String groupName : groupNames) {
            if (!storage.containsKey(groupName)) return false;
            storage.get(groupName).add(contact);
        }
        return true;

//        for (String groupName : groupNames) {
//            List<Contact> groupContact = storage.get(groupName);
//            if (groupContact == null) return false;
//            groupContact.add(contact);
//        }
//        return true;
    }

    public List<Contact> getAllByGroup(String groupName) {
        return storage.get(groupName);
    }

    public Contact getByPhone(String phone) {
        for (List<Contact> listContact : storage.values()) {
            for (Contact contact : listContact) {
                if (contact.getNumber().equals(phone))
                    return contact;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Contact>> group : storage.entrySet()) {
            sb
                    .append(group.getKey())
                    .append("\n");
            for (Contact contact : group.getValue()) {
                sb
                        .append("\t")
                        .append(contact)
                        .append("\n");
            }
        }
        return sb.toString();
    }
}

