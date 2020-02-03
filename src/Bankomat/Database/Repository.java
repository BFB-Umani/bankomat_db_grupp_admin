package Bankomat.Database;

import Bankomat.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private Connection con;

    public Repository() {
        con = dbConnection.getConnection();
    }


    // Tar ut historik för en kund och konto beroende på vilket konto man har valt i comboboxen
    public List<AccountHistory> getLatestHistory(int custId, int accId) {
        List<AccountHistory> accountHistoryList = new ArrayList<>();
        AccountHistory accountHistory = null;

        String query = "SELECT * from accountHistory" +
                " inner join accounttocustomer a on accounthistory.accountId = a.AccountID" +
                " WHERE accountHistory.histDate > DATE_SUB(NOW(), INTERVAL 1 MONTH) AND a.CustomerID = ?" +
                " AND a.accountId = ?;";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, custId);
            stmt.setInt(2, accId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Account account = (getAccountById(rs.getInt("accountId")));
                accountHistory = new AccountHistory(rs.getInt("historyId"), account, rs.getInt("balanceBefore"),
                        rs.getInt("withdraw"), rs.getInt("balanceAfter"), rs.getDate("histDate"));
                accountHistoryList.add(accountHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountHistoryList;
    }

    // Tar ut alla lån en kund kan ha på knappen "Konton&Lån"
    public List<Loan> getLoans(int custId) {
        List<Loan> loanList = new ArrayList<>();

        String query = "SELECT * from loantocustomer " +
                "    inner join loan l on loantocustomer.LoanID = l.LoanID" +
                "    where CustomerID = ?;";

        try (PreparedStatement stmt = con.prepareCall(query)) {
            stmt.setInt(1, custId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Admin admin = getAdminById(rs.getInt("admin"));
                Loan loan = new Loan(rs.getInt("LoanID"), rs.getInt("startAmount"), rs.getInt("paidAmount"),
                        rs.getDouble("interestRate"), rs.getDate("paymentPlan"), admin);
                loanList.add(loan);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loanList;
    }

    // Retunerar ett objekt av Admin baserat på id:n man skickar in
    public Admin getAdminById(int adminId) {
        Admin admin = null;

        String query = "SELECT * from administrator where AdministratorID = ? ;";

        try (PreparedStatement stmt = con.prepareCall(query)) {
            stmt.setInt(1, adminId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                admin = new Admin(rs.getInt("AdministratorID"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("personalNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    // Tar ut pengar från valt konto
    public boolean withdrawMoney(int accId, int amount) {
        String query = "CALL WithdrawFromAccount(?, ?)";

        try (CallableStatement stmt = con.prepareCall(query)) {
            stmt.setInt(1, accId);
            stmt.setInt(2, amount);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    // Lägger in konton i en lista. Tar ut accountId skickar till "getAccountById()" som returnerar Account.
    public List<Account> getAccounts(int custId) {
        List<Account> accountList = new ArrayList<>();

        try (CallableStatement stmt = con.prepareCall("CALL bankdatabase.accountState(?)")) {
            stmt.setInt(1, custId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                accountList.add(getAccountById(rs.getInt("AccountId")));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountList;
    }

    // Tar accountId och skapar ett Account objekt
    public Account getAccountById(int accId) {
        Account account = null;

        String query = "SELECT AccountID, balance from bankdatabase.accounts where AccountId = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, accId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt("AccountID"), rs.getInt("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    // Hämtar klient om Personnr stämmer med Pin.
    public Client getClient(String persNr, int pinCode) {
        Client client = null;
        try (CallableStatement stmt = con.prepareCall("CALL bankdatabase.checkCred(?, ?)")) {
            stmt.setString(1, persNr);
            stmt.setInt(2, pinCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                client = getClientById(rs.getInt("CustomerID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    // Hämtar all klient info med klient id
    public Client getClientById(int custId) {
        Client client = null;

        String query = "SELECT * from bankdatabase.customer where CustomerID = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, custId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                client = new Client(rs.getInt("CustomerID"), rs.getString("firstname")
                        , rs.getString("lastname"), rs.getString("personalNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

//    Skapar en kund
    public void createCustomer(String firstname, String lastname, int pinCode, String personalNumber) {
        try (CallableStatement stmt = con.prepareCall("CALL createCustomer(?, ?, ?, ?);")){
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setInt(3, pinCode);
            stmt.setString(4, personalNumber);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    Raderar en kund
    public void deleteCustomer(String personalNumber){
        try (CallableStatement stmt = con.prepareCall("CALL deleteCustomer(?);")){
            stmt.setString(1, personalNumber);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

// NEDAN BEHÖVS ÄNDRAS TILL DOUBLE I BÅDE JAVA OCH MySQL
//    Ändrar ränta för lån
    public void changeRateForLoan(int loanID, int newRate){
        try (CallableStatement stmt = con.prepareCall("CALL changeRateForLoan(?, ?);")){
            stmt.setInt(1, loanID);
            stmt.setInt(2, newRate);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    Ändrar betalplan på lån
    public void changePaymentPlanForLoan(int loanID, Date newDate){
        try (CallableStatement stmt = con.prepareCall("CALL changePaymentPlanForLoan(?, ?);")){
            stmt.setInt(1, loanID);
            stmt.setDate(2, newDate);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
