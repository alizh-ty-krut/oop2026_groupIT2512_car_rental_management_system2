package components;

import services.CarInventoryService;

public class ReportingComponent {
    private final CarInventoryService carInventoryService;

    public ReportingComponent(CarInventoryService carInventoryService) {
        this.carInventoryService = carInventoryService;
    }

    public void generateFleetReport() {
        System.out.println("\n--- General Fleet Report ---");
        System.out.println("Generating current status of vehicle fleet...");
        try {
            carInventoryService.printInventoryLog();
        } catch (Exception e) {
            System.out.println("Reporting Error: " + e.getMessage());
        }
        System.out.println("----------------------------");
    }

}
