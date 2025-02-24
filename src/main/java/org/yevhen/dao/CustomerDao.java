package org.yevhen.dao;

import org.yevhen.dao.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends DataAccessObject<Customer> {
    public static final String INSERT = "INSERT INTO customer  (name) VALUES (?);";
    public static final String GET_ALL_LIMITED = "SELECT id, name from customer " +
            "ORDER BY name LIMIT ?";
    public static final String GET_ALL_PAGED = "SELECT id, name from customer " +
            "ORDER BY name LIMIT ?";

    public CustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public Customer findById(long id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    @Override
    public Customer update(Customer dto) {
        return null;
    }

    @Override
    public Customer create(Customer dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT)) {
            statement.setString(1, dto.getName());
            statement.execute();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
    }

    public List<Customer> findAllSortedLimited(int limit) {
        List<Customer> list = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_LIMITED);) {
            statement.setInt(1, limit);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setName(rs.getString("name"));
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Customer> findAllSortedPaged(int limit, int pageNumber) {
        List<Customer> list = new ArrayList<>();
        if (limit < 1) limit = 10;
        int offset = (pageNumber - 1) * limit;
        try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_LIMITED);) {
            statement.setInt(1, limit);
            statement.setInt(2, offset);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setName(rs.getString("name"));
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
}
