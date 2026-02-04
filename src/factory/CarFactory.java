package factory;

import models.Car;
import models.SUV;
import models.EconomyCar;
import models.ElectricCar;

public final class CarFactory {

    public enum CarType {
        SUV,
        ECONOMY,
        ELECTRIC
    }

    private CarFactory() {}

    public static Car createCar(CarType type, Integer id, String model, boolean isAvailable) {
        switch (type) {
            case SUV:
                // Default: 7 seats, four‑wheel drive
                return new SUV(id, model, isAvailable, 7, true);
            case ECONOMY:
                // Default: 4 seats, 15 km/L fuel efficiency
                return new EconomyCar(id, model, isAvailable, 4, 15.0);
            case ELECTRIC:
                // Default: 5 seats, 75 kWh battery and 300 km range
                return new ElectricCar(id, model, isAvailable, 5, 75.0, 300.0);
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}