package main;

public class DeliveredState implements PackageState {
    @Override
    public void printStatus() {
        System.out.println("The package has been delivered.");
    }
}