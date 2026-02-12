package services;

import java.util.List;
import models.Car;
import factory.CarFactory;
import repositories.CarRepository;

public class CarInventoryService {
    private final CarRepository carRepository;

    public CarInventoryService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAvailableCars() {
        return carRepository.findAllAvailable();
    }

    public void createNewCar(String model, String typeStr) {
        try {
            CarFactory.CarType type = CarFactory.CarType.valueOf(typeStr.toUpperCase());
            Car newCar = CarFactory.createCar(type, null, model, true);
            carRepository.add(newCar);
            System.out.println("Success! Car added to inventory.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid car type. Please use SUV, ECONOMY, or ELECTRIC.");
        } catch (Exception e) {
            System.out.println("Error adding car: " + e.getMessage());
        }
    }

    public void printInventoryLog() {
        List<Car> cars = getAvailableCars();
        cars.forEach(car -> System.out.println("Car available: " + car.getModel()));
    }
}