package models;

public class EconomyCar extends Car {
    private int seatingCapacity;
    private double fuelEfficiency;

    public EconomyCar(Integer id, String model, boolean isAvailable, int seatingCapacity, double fuelEfficiency) {
        super(id, model, isAvailable);
        this.seatingCapacity = seatingCapacity;
        this.fuelEfficiency = fuelEfficiency;
    }

    public int getSeatingCapacity() {

        return seatingCapacity;
    }
    public void setSeatingCapacity(int seatingCapacity) {

        this.seatingCapacity = seatingCapacity;
    }
    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {

        this.fuelEfficiency = fuelEfficiency;
    }
}