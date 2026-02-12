import components.*;
import services.*;
import repositories.*;
import edu.aitu.oop3.db.DatabaseHandler;

import java.sql.Connection;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        System.out.println("Initializing System...");

        DatabaseHandler dbHandler = DatabaseHandler.getInstance();
        Connection connection = dbHandler.getConnection();

        CarRepository carRepo = new CarRepository(connection);
        RentalRepository rentalRepo = new RentalRepository(connection);
        PaymentRepository paymentRepo = new PaymentRepository(connection);

        PricingService pricingService = new PricingService(5000);

        CarInventoryService inventoryService = new CarInventoryService(carRepo);
        RentalService rentalService = new RentalService(carRepo, rentalRepo);
        PaymentService paymentService = new PaymentService(paymentRepo, rentalRepo, carRepo, pricingService);

        FleetComponent fleetComp = new FleetComponent(inventoryService);
        RentalComponent rentalComp = new RentalComponent(rentalService);
        BillingComponent billingComp = new BillingComponent(paymentService);
        ReportingComponent reportingComp = new ReportingComponent(inventoryService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== CAR RENTAL SYSTEM ===");
            System.out.println("1. View Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return Car & Pay");
            System.out.println("4. Generate Reports");
            System.out.println("5. Add a Car");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            String input = scanner.next();

            switch (input) {
                case "1":
                    fleetComp.showAvailableCars();
                    break;
                case "2":
                    System.out.print("Enter Car ID: ");
                    if (scanner.hasNextInt()) {
                        int carId = scanner.nextInt();
                        System.out.print("Enter Customer ID: ");
                        int custId = scanner.nextInt();
                        rentalComp.rentCar(carId, custId);
                    } else {
                        System.out.println("Invalid input. ID must be a number.");
                        scanner.next();
                    }
                    break;
                case "3":
                    System.out.print("Enter Rental ID to close: ");
                    if (scanner.hasNextInt()) {
                        int rentalId = scanner.nextInt();
                        billingComp.processPayment(rentalId);
                    } else {
                        System.out.println("Invalid input.");
                        scanner.next();
                    }
                    break;
                case "4":
                    reportingComp.generateFleetReport();
                    break;
                case "5":
                    fleetComp.promptAddCar(scanner);
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}