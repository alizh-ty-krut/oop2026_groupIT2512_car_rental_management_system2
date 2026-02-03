package services;

import exceptions.CarNotAvailableException;
import models.Car;
import repositories.CarRepository;
import repositories.RentalRepository;
import models.Rental;
import exceptions.RentalOverlapException;

import java.time.LocalDate;

public class RentalService {
    private final CarRepository carRepository;
    private final RentalRepository rentalRepository;

    public RentalService(CarRepository carRepository, RentalRepository rentalRepository) {
        this.carRepository = carRepository;
        this.rentalRepository = rentalRepository;
    }

    public void createRental(int carId, int customerId) {
        Car car = carRepository.findById(carId);

        if (car == null) {
            throw new RuntimeException("Car with ID " + carId + " was not found.");
        }

        if (!car.getIsAvailable()) {
            throw new CarNotAvailableException("Car " + car.getModel() + " is not available!");
        }

        try {
            rentalRepository.save(new Rental(null, carId, customerId, LocalDate.now()));

            carRepository.updateAvailability(carId, false);

            System.out.println("Success! Car " + car.getModel() + " was rented #" + customerId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
