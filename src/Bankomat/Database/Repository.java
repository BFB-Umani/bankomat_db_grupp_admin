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


    public List<AccountHistory> getIntervalHistory(int accId, String d1, String d2) {
        List<AccountHistory> accountHistoryList = new ArrayList<>();
        AccountHistory accountHistory = null;

        String query = "SELECT * from accountHistory" +
                " WHERE DATE (histDate) BETWEEN" +
                " ? AND ? AND accountId = ?;";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, d1);
            stmt.setString(2, d2);
            stmt.setInt(3, accId);
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



    // Retunerar ett objekt av Admin baserat på id:n man skickar in
    public Admin getAdminById(int adminId) {
        Admin admin = null;

        String query = "SELECT * from administrator where AdministratorID = ? ;";

        try (PreparedStatement stmt = con.prepareCall(query)) {
            stmt.setInt(1, adminId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                admin = new Admin(rs.getInt("AdministratorID"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("personalNumber"), rs.getString("onlinepassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    /

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
    public Client getClient(String persNr) {
        Client client = null;
        try (CallableStatement stmt = con.prepareCall("SELECT * from customer where personalNumber = " + persNr)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int customerID = rs.getInt("customerID");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                int pinCode = rs.getInt("pinCode");
                String personalNumber = rs.getString("personalNumber");

                client = new Client(customerID, firstname, lastname, pinCode, personalNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Admin getAdmin(String personalNumber, String onlinepassword) {
        Admin admin= null;
        try (CallableStatement stmt = con.prepareCall("CALL bankdatabase.getadmin(?,?)")) {
            stmt.setString(1, personalNumber);
            stmt.setString(2, onlinepassword);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                admin = getAdminById(rs.getInt("AdministratorId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }


    //    Skapar en kund
    public void createCustomer(String firstname, String lastname, int pinCode, String personalNumber) {
        try (CallableStatement stmt = con.prepareCall("CALL createCustomer(?, ?, ?, ?);")) {
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setInt(3, pinCode);
            stmt.setString(4, personalNumber);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loan getPaymentPlan() {
        Loan loan = null;
        try(PreparedStatement stmt = con.prepareCall("SELECT * from Loan")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int loanID = rs.getInt("LoanID");
                int startAmount = rs.getInt("startAmount");
                int paidAmount = rs.getInt("paidAmount");
                double interestRate = rs.getDouble("interestRate");
                String paymentPlan = rs.getString("paymentPlan");
                loan = new Loan(loanID, startAmount, paidAmount, interestRate, paymentPlan);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loan;
    }

    //    Raderar en kund
    public void deleteCustomer(String personalNumber) {
        try (CallableStatement stmt = con.prepareCall("CALL deleteCustomer(?);")) {
            stmt.setString(1, personalNumber);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // NEDAN BEHÖVS ÄNDRAS TILL DOUBLE I BÅDE JAVA OCH MySQL
//    Ändrar ränta för lån
    public void changeRateForLoan(int loanID, double newRate) {
        try (CallableStatement stmt = con.prepareCall("CALL changeRateForLoan(?, ?);")) {
            stmt.setInt(1, loanID);
            stmt.setDouble(2, newRate);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    Ändrar betalplan på lån
    public void changePaymentPlanForLoan(int loanID, String newDate) {
        try (CallableStatement stmt = con.prepareCall("CALL changePaymentPlanForLoan(?, ?);")) {
            stmt.setInt(1, loanID);
            stmt.setString(2, newDate);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    Uppdaterar kunds pinkod
    public void updateCustomer(int customerID, int newpinCode) {
        try (CallableStatement stmt = con.prepareCall("CALL updateCustomer(?, ?);")) {
            stmt.setInt(1, customerID);
            stmt.setInt(2, newpinCode);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    raderar konto
    public void deleteAccount(int accountID) {
        try (CallableStatement stmt = con.prepareCall("CALL deleteAccount(?);")) {
            stmt.setInt(1, accountID);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    ändrar ränta för konto
    public void changeRateForAccount(int accountID, double newRate) {
        try (CallableStatement stmt = con.prepareCall("CALL changeAccountRate(?, ?);")) {
            stmt.setInt(1, accountID);
            stmt.setDouble(2, newRate);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAccount(int customerID) {
        try (CallableStatement stmt = con.prepareCall("CALL createAccount(?);")) {
            stmt.setInt(1, customerID);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void depositIntoAccount(int accountID, int amount) {
        try (CallableStatement stmt = con.prepareCall("CALL DepositIntoAccount(?, ?);")) {
            stmt.setInt(1, accountID);
            stmt.setInt(2, amount);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

