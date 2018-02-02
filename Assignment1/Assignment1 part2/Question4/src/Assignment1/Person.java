package Assignment1;

import java.io.Serializable;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Person implements Comparable<Person>, Serializable {

    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    private String firstName;                                                                        
    private String lastname;                                                                          
    private static final long serialVersionUID = 1002L;
    // Constructor

    public Person(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return firstName + " " + lastname;
    }

    public String getSecondName() {
        return lastname;
    }

    // Compare Person objects
    public int compareTo(Person person) {
        int result = lastname.compareTo(person.lastname);
        return result == 0 ? firstName.compareTo(person.firstName) : result;
    }

    @Override
    public boolean equals(Object person) {
        return compareTo((Person) person) == 0;
    }

    @Override
    public int hashCode() {
        return 7 * firstName.hashCode() + 13 * lastname.hashCode();
    }

    // Read a person from the keyboard
    public static Person readPerson() {
        String firstName = null;
        String surname = null;
        try {
            System.out.print("Enter first name: ");
            firstName = keyboard.readLine().trim();
            System.out.print("Enter surname: ");
            surname = keyboard.readLine().trim();
        } catch (IOException e) {
            System.err.println("Error reading a name.");
            e.printStackTrace();
            System.exit(1);
        }
        return new Person(firstName, surname);
    }

}
