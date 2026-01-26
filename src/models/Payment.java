package models;

public class Payment {
    private int id;
    private int rental_id;
    private int amount;

    public Payment(int id , int rental_id, int amount) {
        this.id = id;
        this.rental_id = rental_id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getRental_id() {
        return rental_id;
    }
    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
