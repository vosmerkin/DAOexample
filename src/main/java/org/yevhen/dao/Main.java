package org.yevhen.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost:5435",
                "marketplace",
                "postgres",
                "password");
        try {
            Connection connection = dcm.getConnection();

            create(connection);

            getAll(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void create(Connection connection) {
        CustomerDao customerDao = new CustomerDao(connection);
        Customer customer = new Customer();
        customer.setName("qwer");

        customerDao.create(customer);
    }

    public static void getAll(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM customer;");
//        ResultSet rs = statement.executeQuery("select * from information_schema.tables;");
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }
    }

}