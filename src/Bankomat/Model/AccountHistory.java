package Bankomat.Model;

import java.sql.Date;

public class AccountHistory {
    private int id;
    private Account account;
    private int balanceBefore;
    private int withdraw;
    private int balanceAfter;
    private Date date;

    public AccountHistory(int id, Account account, int balanceBefore, int withdraw, int balanceAfter, Date date) {
        this.id = id;
        this.account = account;
        this.balanceBefore = balanceBefore;
        this.withdraw = withdraw;
        this.balanceAfter = balanceAfter;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public int getBalanceBefore() {
        return balanceBefore;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public int getBalanceAfter() {
        return balanceAfter;
    }

    public Date getDate() {
        return date;
    }
}
