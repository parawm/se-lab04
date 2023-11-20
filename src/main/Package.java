package main;
public class Package {
    private PackageState state;
    private ShippingStrategy strategy;
    private double weight;

    public Package(double weight) {
        this.weight = weight;
        this.state = new PackageAcceptedState();
        this.strategy = new StandardShipping();
    }

    public void setState(PackageState state) {
        this.state = state;
    }

    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public double getWeight() {
        return weight;
    }

    public void printStatus() {
        state.printStatus();
    }

    public double calculateShippingCost() {
        return strategy.calculateCost(this);
    }
}