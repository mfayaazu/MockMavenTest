package com.fayaaz.ali.services;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTest {

    protected static void addTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS USERS"
                + "(id Integer AUTO_INCREMENT, "
                + "firstname VARCHAR(50), "
                + "lastname VARCHAR(50), "
                + "age Integer, "
                + "PRIMARY KEY (id))";
        statement.executeUpdate(sql);
    }

    protected static void insertData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO USERS "
                + "(firstname, lastname, age) "
                + "values "
                + "('Fayaaz','Ali',29),"
                + "('Liam','Håkansson',26),"
                + "('Eva','Böralv',28),"
                + "('Team','Nardo',100)";
        statement.executeUpdate(sql);
    }

    protected static Connection getH2Connection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }

 /*   protected static void dropTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE USERS");
    }
*/

   protected static Connection getMySQLConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/fayaaz123","root","Sep@2019");
    }


    protected static Connection getOracleSQLConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","root","Sep@2019");
    }
}
