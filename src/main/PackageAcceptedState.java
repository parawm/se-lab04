package main;

public class PackageAcceptedState implements PackageState {
    @Override
    public void printStatus() {
        System.out.println("The package is accepted.");
    }
}