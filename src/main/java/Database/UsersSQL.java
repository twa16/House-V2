/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Manuel Gauto <manuelg@manuwebdev.com>
 */
public class UsersSQL {

    public static String getUserPassword(String username,Connection conn) {
        ResultSet rs = null;
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM USERS WHERE USER='" + username + "'");

            while (rs.next()) {
                return rs.getString("PASSWORD");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static String getFacebookKey(String username,Connection conn) {
        ResultSet rs = null;
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM USERS WHERE USER='" + username + "'");

            while (rs.next()) {
                return rs.getString("FBKEY");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
