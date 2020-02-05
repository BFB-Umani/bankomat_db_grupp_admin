package Bankomat.Model;

// Osäker om relationsmodellen ska följas??
public class AccountToCustomer {
    private int id;
    private Client client;
    private Account account;

    public AccountToCustomer(int id, Client client, Account account) {
        this.id = id;
        this.client = client;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Account getAccount() {
        return account;
    }
}
