package services;

import models.Rental;
import java.time.LocalDate;

public class PricingService {
    private final int dailyRate;

    public PricingService(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int calculatePrice(Rental rental) {
        long startDay = rental.getRentalDate().toEpochDay();
        long todayDay = LocalDate.now().toEpochDay();
        long days = todayDay - startDay;
        if (days < 1) {
            days = 1;
        }
        return (int) (days * dailyRate);
    }
}

