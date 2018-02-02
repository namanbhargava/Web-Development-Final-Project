package Assignment1;

import java.io.Serializable;

class BookEntry implements Comparable<BookEntry>, Serializable {

    private Person person;
    private PhoneNumber number;
    private static final long serialVersionUID = 1002L;

    public BookEntry(Person person, PhoneNumber number) {
        this.person = person;
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public PhoneNumber getNumber() {
        return number;
    }

    public int compareTo(BookEntry entry) {
        return person.compareTo(entry.getPerson());
    }

    @Override
    public String toString() {
        return person.toString() + '\n' + number.toString();
    }

   
    public static BookEntry readEntry() {
        return new BookEntry(Person.readPerson(), PhoneNumber.readNumber());
    }

}
