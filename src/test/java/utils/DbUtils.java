package utils;

import java.sql.*;

public class DbUtils {

    private static final String URL = "jdbc:postgresql://localhost:5432/crm";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    public static String getCustomerById(int id) throws SQLException {
        String name = null;
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("SELECT name FROM customers WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            name = rs.getString("name");
        }
        rs.close(); stmt.close(); conn.close();
        return name;
    }
}
