package models;

public class SUV extends Car {
    private int seatingCapacity;
    private boolean fourWheelDrive;



    public SUV(Integer id, String model, boolean isAvailable, int seatingCapacity, boolean fourWheelDrive) {
        super(id, model, isAvailable);
        this.seatingCapacity = seatingCapacity;
        this.fourWheelDrive = fourWheelDrive;
    }

    public int getSeatingCapacity() {

        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {

        this.seatingCapacity = seatingCapacity;
    }

    public boolean isFourWheelDrive() {

        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {

        this.fourWheelDrive = fourWheelDrive;
    }
    //
}