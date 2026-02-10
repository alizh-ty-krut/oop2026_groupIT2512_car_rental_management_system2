package services;

import java.util.List;
import models.Car;
import repositories.CarRepository;

public class CarInventoryService {
    private final CarRepository carRepository;

    public CarInventoryService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAvailableCars() {
        return carRepository.findAllAvailable();
    }

    public void printInventoryLog() {
        List<Car> cars = getAvailableCars();

        cars.forEach(car -> System.out.println("Car available: " + car));
        //for (Car car : cars) {
        //    System.out.println("Car available: " + car);
        //}
    }
}
