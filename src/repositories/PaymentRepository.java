package repositories;

import java.sql.*;
import models.Payment;


public class PaymentRepository {
    private final Connection connection;

    public PaymentRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Payment payment) {
        String sql = "INSERT INTO payments (rental_id, amount) VALUES (?, ?)";

        try (PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setInt(1, payment.getRental_id());
            st.setInt(2, payment.getAmount());
            st.executeUpdate();
            ResultSet keys = st.getGeneratedKeys();
            if (keys.next()) {
                payment.setId(keys.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Error saving payment: " + e.getMessage());
        }
    }
}