package components;

import services.PaymentService;

public class BillingComponent {
    private final PaymentService paymentService;

    public BillingComponent(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processPayment(int rentalId) {
        System.out.println("\n--- Processing Payment ---");
        try {
            // Delegate logic to the service
            paymentService.processPayment(rentalId);
        } catch (Exception e) {
            System.out.println("Billing Error: " + e.getMessage());
        }
        System.out.println("--------------------------");
    }
}