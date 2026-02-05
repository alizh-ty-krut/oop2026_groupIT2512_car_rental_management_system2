package models;

public class InsurancePolicy {

    private static InsurancePolicy instance;

    private double coverageAmount;
    private double dailyCost;

    private InsurancePolicy() {
        this.coverageAmount = 50000.0;
        this.dailyCost = 15.0;
    }

    public static InsurancePolicy getInstance() {
        return instance;
    }

    public double getDailyCost() {
        return dailyCost;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }
}