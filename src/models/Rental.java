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

package models;

import java.time.LocalDate;

public class Rental {
    private Integer id;
    private int carId;
    private int customerId;
    private LocalDate rentalDate;

    public Rental(Integer id, int carId, int customerId, LocalDate rentalDate) {
        setId(id);
        setCarId(carId);
        setCustomerId(customerId);
        setRentalDate(rentalDate);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public LocalDate getRentalDate() { return rentalDate; }
    public void setRentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; }

}