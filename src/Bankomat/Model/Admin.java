package Bankomat.Model;

public class Admin {
    private int id;
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String password;

    public Admin(int id, String firstName, String lastName, String personalNumber, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.password = password;
    }
    public Admin(){

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getPassword() {
        return password;
    }
}
