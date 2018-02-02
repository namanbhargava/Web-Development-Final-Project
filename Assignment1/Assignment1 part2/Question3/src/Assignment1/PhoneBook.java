package Assignment1;
import java.nio.file.*;
import java.io.*;
import java.util.*;

class PhoneBook implements Serializable {
  
  public void listEntries() {
   
    LinkedList<BookEntry> entries = new LinkedList<>(phonebook.values());
    Collections.sort(entries);

    for(BookEntry entry : entries) {
      System.out.println(entry);
    }
  }
  @SuppressWarnings("unchecked")
  public PhoneBook() {
    if(Files.exists(file)) {  
      try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(file)))){
        phonebook = (HashMap<Person, BookEntry>)in.readObject();  
        numberbook = (HashMap<PhoneNumber, BookEntry>)in.readObject();
      } catch(ClassNotFoundException | IOException e) {
        e.printStackTrace();
        System.exit(1);
      }
    }
  }

  public void save() {
    try {
      Files.createDirectories(file.getParent());
    } catch (IOException e) {
      System.err.println("I/O error creating directory. " + e.getMessage());
      e.printStackTrace();
      System.exit(1);
    }
    try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))){
      System.out.println("Saving phone book");
      out.writeObject(phonebook);
      out.writeObject(numberbook); 
      System.out.println("Done");
    } catch(IOException e) {
      System.out.println("I/O error saving phone book. " + e.getMessage());
      e.printStackTrace();
      System.exit(1);
    }
  }

  public void addEntry(BookEntry entry) {
    phonebook.put(entry.getPerson(), entry);
    numberbook.put(entry.getNumber(), entry);
  }

  public BookEntry getEntry(PhoneNumber number) {
    return numberbook.get(number);
  }

  public BookEntry getEntry(Person person) {
    return phonebook.get(person);
  }

  public PhoneNumber getNumber(Person person) {
    BookEntry entry = getEntry(person);
    if(entry != null) {
    return entry.getNumber();
    } else {
      return null;
    }
  }

  public Person getPerson(PhoneNumber number) {
     BookEntry entry = getEntry(number);
    if(entry != null) {
    return entry.getPerson();
    } else {
      return null;
    }
  }

  private HashMap<Person,BookEntry> phonebook = new HashMap<>();
  private HashMap<PhoneNumber,BookEntry> numberbook = new HashMap<>();
  private static final long serialVersionUID = 1001L;
  private Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("Phonebook.bin");
}
