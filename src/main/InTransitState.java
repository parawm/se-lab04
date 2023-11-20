package main;

public class InTransitState implements PackageState {
    @Override
    public void printStatus() {
        System.out.println("The package is in-transit.");
    }
}