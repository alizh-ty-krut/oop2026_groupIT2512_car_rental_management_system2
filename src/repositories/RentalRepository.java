package repositories;

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

import java.sql.*;
import java.time.LocalDate;
import models.Rental;

public class RentalRepository implements FindById<Rental>, Save<Rental> {

    private final Connection connection;

    public RentalRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Rental rental) {
        String sql = "INSERT INTO rentals (car_id, customer_id, rental_date) VALUES (?, ?, ?)";

        try (PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setInt(1, rental.getCarId());
            st.setInt(2, rental.getCustomerId());
            st.setDate(3, Date.valueOf(rental.getRentalDate()));

            st.executeUpdate();

            ResultSet keys = st.getGeneratedKeys();
            if (keys.next()) {
                rental.setId(keys.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при сохранении аренды: " + e.getMessage());
        }
    }

    @Override
    public Rental findById(int id) {
        String sql = "SELECT * FROM rentals WHERE id = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return new Rental(
                        rs.getInt("id"),
                        rs.getInt("car_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("rental_date").toLocalDate() // Превращаем SQL Date обратно в LocalDate
                );
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при поиске аренды: " + e.getMessage());
        }
        return null;
    }
}