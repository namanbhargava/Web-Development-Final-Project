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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PhoneBook book = new PhoneBook();                                
        FormattedInput in = new FormattedInput();                          
        Person someone;
        PhoneNumber phoneNumber;
        while (true) {
            System.out.println("Enter 1 to enter a new phone book entry\n"
                             + "Enter 2 to find the number for a name\n"
                             + "Enter 3 to find the name for a number\n"
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
                    someone = Person.readPerson();
                    BookEntry entry = book.getEntry(someone);
                    if (entry == null) {
                        System.out.println("The number not found.");
                    } else {
                        System.out.println("The number for " + someone + " is " + entry.getNumber());
                    }
                    break;
                case 3:
                    phoneNumber = PhoneNumber.readNumber();
                    BookEntry entry1 = book.getEntry(phoneNumber);
                    if (entry1 == null) {
                        System.out.println("The name not found.");
                    } else {
                        System.out.println("The name for " + phoneNumber + " is " + entry1.getPerson());
                    }
                    break;

                case 9:
                    System.out.println("Ending program.");
                    return;
                default:
                    System.out.println("Invalid selection, try again.");
                    break;
            }
        }
    }
    
    
}
