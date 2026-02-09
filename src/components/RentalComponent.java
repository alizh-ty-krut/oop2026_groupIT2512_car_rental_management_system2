package components;

import services.RentalService;

public class RentalComponent {
    private final RentalService rentalService;

    public RentalComponent(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    public void rentCar(int carId, int customerId) {
        System.out.println("\n--- Processing Rental ---");
        try {
            rentalService.createRental(carId, customerId);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("-------------------------");
    }
}