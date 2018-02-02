/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

/**
 *
 * @author bharg
 */
public class NewPhoneBook {

    public static void main(String[] args) {
        // TODO code application logic here
        PhoneBook book = new PhoneBook();
        FormattedInput in = new FormattedInput();
        Person someone;
        BookEntry[] lastNameRecords;
        while (true) {
            System.out.println("Enter 1 to enter a new phone book entry\n"
                    + "Enter 2 to list all numbers for last name\n"
                    + "Enter 3 to list all the entries\n"
                    + "Enter 9 to quit.");
            int what = 0;
            try {
                what = in.readInt();

            } catch (InvalidUserInputException e) {
                System.out.println(e.getMessage() + "\nTry again.");
                continue;
            }

            switch (what) {
                case 1:
                    book.addEntry(BookEntry.readEntry());
                    break;
                case 2:
                    System.out.println("\nEnter last name:");
                    String lastName = null;
                    try {
                        lastName = in.readString().trim();
                    } catch (InvalidUserInputException e) {
                        System.out.println(e.getMessage() + "\nError.");
                        break;
                    }
                    lastNameRecords = book.getEntries(lastName);
                    if (lastNameRecords.length == 0) {
                        System.out.println("No records found for " + lastName);
                    } else {
                        System.out.println("Entries found for " + lastName + ":");
                        for (BookEntry record : lastNameRecords) {
                            System.out.println("\n" + record);
                        }
                    }

                    break;
                case 3:
                    book.listEntries();
                    break;

                case 9:
                    book.save();
                    System.out.println("Ending program.");
                    return;
                default:
                    System.out.println("Invalid selection, try again.");
                    break;
            }
        }
    }
}
