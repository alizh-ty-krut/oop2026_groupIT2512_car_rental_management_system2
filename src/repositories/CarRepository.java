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
import models.Car;

public class CarRepository {

    private final Connection connection;

    public CarRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Car> findAllAvailable() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE is_available = true";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                cars.add(new Car(
                        rs.getInt("id"),
                        rs.getString("model"),
                        rs.getBoolean("is_available")
                ));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cars;
    }

    public void updateAvailability(int id, boolean status) {
        String sql = "UPDATE cars SET is_available = ? WHERE id = ?"; // ? - placeholder

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setBoolean(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Car findById(int id) {
        String sql = "SELECT * FROM cars WHERE id = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return new Car(
                        rs.getInt("id"),
                        rs.getString("model"),
                        rs.getBoolean("is_available")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void add(Car car) {
        String sql = "INSERT INTO cars (model, is_available) VALUES (?, ?)";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, car.getModel());
            st.setBoolean(2, car.getIsAvailable());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}