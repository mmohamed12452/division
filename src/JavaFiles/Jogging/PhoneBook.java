package JavaFiles.Jogging;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class PhoneBook {
    static final int NAME_LENGTH = 20;
    static final int PHONE_LENGTH = 15;
    static final int RECORD_SIZE = (NAME_LENGTH * 2) + (PHONE_LENGTH * 2) + 4;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("phonebook.dat", "rw");
        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Display All");
            System.out.println("3. Search by Name");
            System.out.println("4. Update Phone");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addContact(file);
                    break;
                case 2:
                    displayContacts(file);
                    break;
                case 3:
                    searchContact(file);
                    break;
                case 4:
                    updateContact(file);
                    break;
                case 5:
                    deleteContact(file);
                    break;
                case 6:
                    file.close();
                    return;
            }
        }
    }

    // Pad or trim string to fixed length
    static String fixLength(String s, int length) {
        if (s.length() > length)
            return s.substring(0, length);
        return String.format("%-" + length + "s", s);
    }

    // 1. Add Contact
    static void addContact(RandomAccessFile file) throws IOException {
        file.seek(file.length());

        System.out.print("Enter name: ");
        String name = fixLength(sc.nextLine(), NAME_LENGTH);

        System.out.print("Enter phone: ");
        String phone = fixLength(sc.nextLine(), PHONE_LENGTH);

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        file.writeChars(name);
        file.writeChars(phone);
        file.writeInt(age);

        System.out.println("Contact added!");
    }

    // 2. Display All
    static void displayContacts(RandomAccessFile file) throws IOException {
        file.seek(0);

        while (file.getFilePointer() < file.length()) {
            String name = readString(file, NAME_LENGTH);
            String phone = readString(file, PHONE_LENGTH);
            int age = file.readInt();

            // Skip deleted records (marked with '*')
            if (name.charAt(0) == '*') continue;

            System.out.println("Name: " + name.trim() +
                    ", Phone: " + phone.trim() +
                    ", Age: " + age);
        }
    }

    // Helper to read fixed-length string
    static String readString(RandomAccessFile file, int length) throws IOException {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = file.readChar();
        }
        return new String(chars);
    }

    // 3. Search by Name
    static void searchContact(RandomAccessFile file) throws IOException {
        System.out.print("Enter name to search: ");
        String search = sc.nextLine().trim();

        file.seek(0);

        while (file.getFilePointer() < file.length()) {
            long pos = file.getFilePointer();

            String name = readString(file, NAME_LENGTH);
            String phone = readString(file, PHONE_LENGTH);
            int age = file.readInt();

            if (name.trim().equalsIgnoreCase(search) && name.charAt(0) != '*') {
                System.out.println("Found: " + name.trim() +
                        ", Phone: " + phone.trim() +
                        ", Age: " + age);
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    // 4. Update Phone
    static void updateContact(RandomAccessFile file) throws IOException {
        System.out.print("Enter name to update: ");
        String search = sc.nextLine().trim();

        file.seek(0);

        while (file.getFilePointer() < file.length()) {
            long pos = file.getFilePointer();

            String name = readString(file, NAME_LENGTH);

            if (name.trim().equalsIgnoreCase(search) && name.charAt(0) != '*') {
                System.out.print("Enter new phone: ");
                String newPhone = fixLength(sc.nextLine(), PHONE_LENGTH);

                file.seek(pos + NAME_LENGTH * 2); // move to phone field
                file.writeChars(newPhone);

                System.out.println("Phone updated!");
                return;
            }

            file.skipBytes((PHONE_LENGTH * 2) + 4);
        }

        System.out.println("Contact not found.");
    }

    // 5. Delete Contact (soft delete)
    static void deleteContact(RandomAccessFile file) throws IOException {
        System.out.print("Enter name to delete: ");
        String search = sc.nextLine().trim();

        file.seek(0);

        while (file.getFilePointer() < file.length()) {
            long pos = file.getFilePointer();

            String name = readString(file, NAME_LENGTH);

            if (name.trim().equalsIgnoreCase(search) && name.charAt(0) != '*') {
                file.seek(pos);
                file.writeChar('*'); // mark as deleted

                System.out.println("Contact deleted!");
                return;
            }

            file.skipBytes((PHONE_LENGTH * 2) + 4);
        }

        System.out.println("Contact not found.");
    }
}

