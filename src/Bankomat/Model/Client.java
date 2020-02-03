package Bankomat.Model;

public class Client {
    private int ID;
    private String firstName;
    private String lastName;
    private int pinCode;
    private String personNr;

    public Client(int ID, String firstName, String lastName, int pinCode, String personNr) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personNr = personNr;
    }

    public Client() {

    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getPersonNr() {
        return personNr;
    }
}
