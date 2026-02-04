package models;

public class ElectricCar extends Car {
    private int seatingCapacity;
    private double batteryCapacity;
    private double range;
    public ElectricCar(Integer id, String model, boolean isAvailable, int seatingCapacity, double batteryCapacity, double range) {
        super(id, model, isAvailable);
        this.seatingCapacity = seatingCapacity;
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    public int getSeatingCapacity() {

        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {

        this.seatingCapacity = seatingCapacity;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {

        this.batteryCapacity = batteryCapacity;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {

        this.range = range;
    }
}