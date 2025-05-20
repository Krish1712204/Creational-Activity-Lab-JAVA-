package dao;

import model.User;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class UserDAO {
    public void addUser(User user) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO users(name, email) VALUES (?, ?)")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                list.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteUserUsingProcedure(int id) {
        try (Connection con = DBConnection.getConnection();
             CallableStatement cs = con.prepareCall("{call delete_user(?)}")) {
            cs.setInt(1, id);
            cs.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}