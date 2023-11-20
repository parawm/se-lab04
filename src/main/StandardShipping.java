package main;

public class StandardShipping implements ShippingStrategy {
    @Override
    public double calculateCost(Package p) {
        return p.getWeight() * 2.5;
    }
}