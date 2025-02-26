package tp2.src.main.java.edu.ensai.library;

public class Author extends Person {

    // Attributes
    public String nationality;

    // Constructor
    public Author(String firstName, String lastName, int age, String nationality) {
        super(firstName, lastName, age);
        this.nationality = nationality;
    }
}
