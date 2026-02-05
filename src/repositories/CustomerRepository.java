/**
 * ▄█▀█▄
 * ▄█▀▀▀▀    ▀█▄▄▄▄▄▄▄
 * █▀                ▀█
 * ▀▄ ▄              ▄█
 * █████▄▄▄▄▄██▄▄▄█▀▀█
 * █▀█    ▀     ▀    █▀▀▀▀▀█
 * █ ███▄▄▄▄   ▄▄▄▄▄██▀▀██ █
 * █ ███ ████▀████ ███  █  █
 * █▄███ ████ ████ ███  █ █▀
 * ███ ████ ████ ███  █ █
 * ███ ████ ████ ███▄▄█ █
 * ███ ████ ████ ███   ▄█
 * ███ ████ ████ ███▀▀▀▀
 * ▄███▄████ ████▄███▄
 * ███▀███████████▀███
 * ▀▀▀██▄▄▄▄▄██▀▀▀
 */

package repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Customer;


public class CustomerRepository implements FindById<Customer>, Save<Customer> {
    private final Connection connection;
    public CustomerRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Customer customer) {
        String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, customer.getName());
            st.setString(2, customer.getEmail());
            st.executeUpdate();
            ResultSet keys = st.getGeneratedKeys();
            if (keys.next()) {
                customer.setId(keys.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Error saving customer: " + e.getMessage());
        }
    }
    @Override
    public Customer findById(int id) {
        String sql = "SELECT * FROM customers WHERE id = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                return new Customer(

                        rs.getInt("id"),

                        rs.getString("name"),

                        rs.getString("email")

                );

            }

        } catch (SQLException e) {

            System.err.println("Error finding customer: " + e.getMessage());

        }

        return null;

    }

}

