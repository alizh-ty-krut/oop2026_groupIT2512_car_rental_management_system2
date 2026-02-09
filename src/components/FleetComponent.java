package components;

import java.util.List;
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
}