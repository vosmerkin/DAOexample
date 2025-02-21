package org.yevhen.dao;

import org.yevhen.dao.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDao extends DataAccessObject<Customer> {
    public static final String INSERT = "INSERT INTO customer  (name) VALUES (?);";
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
            statement.setString(1,dto.getName());
            statement.execute();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {

    }
}
