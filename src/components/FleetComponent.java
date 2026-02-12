package components;

import java.util.List;
import java.util.Scanner;
import models.Car;
import services.CarInventoryService;

public class FleetComponent {
    private final CarInventoryService carInventoryService;

    public FleetComponent(CarInventoryService carInventoryService) {
        this.carInventoryService = carInventoryService;
    }

    public void showAvailableCars() {
        System.out.println("\n--- Fleet Inventory ---");
        List<Car> cars = carInventoryService.getAvailableCars();
        if (cars.isEmpty()) {
            System.out.println("No cars available at the moment.");
        } else {
            for (Car car : cars) {
                System.out.printf("ID: %d | Model: %s%n", car.getId(), car.getModel());
            }
        }
        System.out.println("-----------------------");
    }

    public void promptAddCar(Scanner scanner) {
        System.out.println("\n--- Add New Car ---");

        System.out.print("Enter Car Model: ");
        String model = scanner.next();

        System.out.print("Enter Car Type (SUV, ECONOMY, ELECTRIC): ");
        String type = scanner.next();

        carInventoryService.createNewCar(model, type);
    }
}