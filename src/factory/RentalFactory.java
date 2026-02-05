package factory;

import java.time.LocalDate;
import models.Rental;

public final class RentalFactory {

    private RentalFactory() {
    }

    public static Rental createRental(Integer id, int carId, int customerId, LocalDate date) {
        return new Rental(id, carId, customerId, date);
    }
//fefe
    public static Rental createRental(Integer id, int carId, int customerId) {
        return new Rental(id, carId, customerId, LocalDate.now());
    }
}