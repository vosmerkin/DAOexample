package org.yevhen.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
       DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                                                            "customerdb",
                                                                "sa",
                                                                "postgres")  ;
       try {
           Connection connection = dcm.getConnection();
           Statement statement = connection.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * FROM customer;");
           while (rs.next()){
               System.out.println(rs.getInt(1));
           }

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }
}