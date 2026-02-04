package models;

import java.time.LocalDate;

public class RentalContract {
    private final Integer id;
    private final Car car;
    private final Customer customer;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double totalPrice;

    private RentalContract(Builder builder) {
        this.id = builder.id;
        this.car = builder.car;
        this.customer = builder.customer;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.totalPrice = builder.totalPrice;
    }

    public Integer getId() { return id; }
    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalPrice() { return totalPrice; }

    public static class Builder {
        private Integer id;
        private Car car;
        private Customer customer;
        private LocalDate startDate;
        private LocalDate endDate;
        private double totalPrice;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }


        public Builder withCar(Car car) {
            this.car = car;
            return this;
        }

        public Builder withCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder withTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public RentalContract build() {
            if (car == null) {
                throw new IllegalStateException("Car must be specified");
            }
            if (customer == null) {
                throw new IllegalStateException("Customer must be specified");
            }
            if (startDate == null) {
                throw new IllegalStateException("Start date must be specified");
            }
            return new RentalContract(this);
        }
    }
}