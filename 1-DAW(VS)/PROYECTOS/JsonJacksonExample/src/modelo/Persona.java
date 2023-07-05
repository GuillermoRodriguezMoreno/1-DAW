package modelo;

public class Persona {
    
    // Atributos

    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String number;

    // Constructores

    public Persona(){


    }

    // Metodos

    @Override
    public String toString() {
        
        return this.firstName + " " + this.lastName + " " + this.gender + " " + this.age + " " + this.number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // Getters y Setters

    
}
