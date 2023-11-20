package main;

public class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculateCost(Package p) {
        return p.getWeight() * 3.5;
    }
}