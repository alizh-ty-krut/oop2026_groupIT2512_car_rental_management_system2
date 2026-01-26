package services;

import models.Payment;
import models.Rental;
import repositories.PaymentRepository;
import repositories.RentalRepository;
import repositories.CarRepository;

public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final PricingService pricingService;

    public PaymentService(PaymentRepository paymentRepository,
                          RentalRepository rentalRepository,
                          CarRepository carRepository,
                          PricingService pricingService) {
        this.paymentRepository = paymentRepository;
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
        this.pricingService = pricingService;
    }

    public void processPayment(int rentalId) {
        Rental rental = rentalRepository.findById(rentalId);
        if (rental == null) {
            throw new RuntimeException("Rental with ID " + rentalId + " not found.");
        }
        int amount = pricingService.calculatePrice(rental);
        Payment payment = new Payment(0, rentalId, amount);
        paymentRepository.save(payment);
        // Make the car available again
        carRepository.updateAvailability(rental.getCarId(), true);
        System.out.println("Payment recorded for rental " + rentalId +
                " with amount " + amount);
    }
}
