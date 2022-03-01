package com.company;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        fillGroups(phoneBook);
        fillContacts(phoneBook);
        System.out.println(phoneBook);
        System.out.println("\n\nВсе контакты группы");
        final List<Contact> friends = phoneBook.getAllByGroup("Друзья");
        for (Contact friend : friends) {
            System.out.println(friend);
        }

        System.out.println("\n\nКонтакт по номеру телефона");
        final Contact byPhone = phoneBook.getByPhone("+7-910-522-65-96");
        System.out.println(byPhone);

    }

    private static void fillGroups(PhoneBook phoneBook) {
        phoneBook.addGroup("Семья");
        phoneBook.addGroup("Друзья");
        phoneBook.addGroup("Работа");
        phoneBook.addGroup("VIP");
    }

    static void fillContacts(PhoneBook phoneBook) {
        phoneBook.addContactToGroup(
                PhoneBook.crateContact("Mike", "+7-910-522-65-96"), "Друзья");
        phoneBook.addContactToGroup(
                PhoneBook.crateContact("Петр", "+7-910-111-22-33"), "Друзья", "Работа");
        phoneBook.addContactToGroup(
                PhoneBook.crateContact("Mike", "+7-910-999-55-44"), "Друзья", "Семья");

    }
}
