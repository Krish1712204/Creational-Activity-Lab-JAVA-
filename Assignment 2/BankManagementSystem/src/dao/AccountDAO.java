package dao;

import model.Account;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class AccountDAO {
    public void createAccount(Account account) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO accounts(name, balance) VALUES (?, ?)")) {
            ps.setString(1, account.getName());
            ps.setDouble(2, account.getBalance());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM accounts")) {
            while (rs.next()) {
                list.add(new Account(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("balance")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}