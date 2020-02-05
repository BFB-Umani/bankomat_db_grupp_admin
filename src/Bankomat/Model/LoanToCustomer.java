package Bankomat.Model;

public class LoanToCustomer {
    private int id;
    private Client client;
    private Loan loan;
    private boolean pending;
    private boolean accepted;

    public LoanToCustomer(int id, Client client, Loan loan, boolean pending, boolean accepted) {
        this.id = id;
        this.client = client;
        this.loan = loan;
        this.pending = pending;
        this.accepted = accepted;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Loan getLoan() {
        return loan;
    }

    public boolean isPending() {
        return pending;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
