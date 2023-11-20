package main;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the weight of Package");
        float weight = sc.nextFloat();
        Package p = new Package(weight);
        p.printStatus();

        System.out.println("\nShipping cost for standard delivery: " + p.calculateShippingCost());


        p.setStrategy(new ExpressShipping());
        System.out.println("Shipping cost for express delivery: " + p.calculateShippingCost());


        System.out.println("\nPlease choose your shipping type:\n1:Standard Shipping\n2:Express Shipping");
        int shippingMethod = sc.nextInt();


        p.setStrategy(getShipmentMethod(shippingMethod));
        p.setState(new InTransitState());
        p.printStatus();


        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            System.out.println("\nChange Shipping Method by pressing:\n1:Standard Shipping\n2:Express Shipping");
            while (!Thread.currentThread().isInterrupted()) {
                if (sc.hasNextInt()) {
                    int method = sc.nextInt();
                    p.setStrategy(getShipmentMethod(method));
                    System.out.println("Shipping Method changed. New Shipping Cost: " + p.calculateShippingCost());
                    p.printStatus();
                }
            }
            return null;
        });

        try {
            future.get(10, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
            p.setState(new DeliveredState());
            p.printStatus();
            System.exit(0);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdownNow();

    }

    public static ShippingStrategy getShipmentMethod(int type){
        if (type==1){
            return new StandardShipping();
        } else if  (type == 2)
            return new ExpressShipping();
        else
            return null;
    }

}