import java.sql.*;

public class BankService {

    public void createAccount(Account acc) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO accounts(name,balance) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, acc.name);
            ps.setDouble(2, acc.balance);
            ps.executeUpdate();
            System.out.println("Account Created!");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void deposit(int accNo, double amount) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE accounts SET balance = balance + ? WHERE accNo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, amount);
            ps.setInt(2, accNo);
            ps.executeUpdate();
            System.out.println("Money Deposited!");
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public void withdraw(int accNo, double amount) {
    try {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE accounts SET balance = balance - ? WHERE accNo=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDouble(1, amount);
        ps.setInt(2, accNo);
        ps.executeUpdate();
        System.out.println("Money Withdrawn!");
    } catch(Exception e){
        System.out.println(e);
    }
}
public void checkBalance(int accNo) {
    try {
        Connection con = DBConnection.getConnection();
        String query = "SELECT balance FROM accounts WHERE accNo=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, accNo);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            System.out.println("Balance: " + rs.getDouble("balance"));
        } else {
            System.out.println("Account not found!");
        }
    } catch(Exception e){
        System.out.println(e);
    }
}
}