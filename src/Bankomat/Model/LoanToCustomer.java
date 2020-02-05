package Bankomat.Model;

public class LoanToCustomer {
    private int id;
    private int clientID;
    private int loanID;
    private boolean pending;
    private boolean accepted;
    private int amount;

    public LoanToCustomer(int id, int clientID, int loanID, boolean pending, boolean accepted, int amount) {
        this.id = id;
        this.clientID = clientID;
        this.loanID = loanID;
        this.pending = pending;
        this.accepted = accepted;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getClientID() {
        return clientID;
    }

    public int getLoanID() {
        return loanID;
    }

    public boolean isPending() {
        return pending;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public int getAmount() {
        return amount;
    }
}
