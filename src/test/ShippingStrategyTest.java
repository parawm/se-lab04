package test;

import main.ExpressShipping;
import main.Package;
import main.ShippingStrategy;
import main.StandardShipping;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShippingStrategyTest {
    @Test
    public void testStandardShipping() {
        ShippingStrategy strategy = new StandardShipping();
        Package p = new Package(10.0);
        assertEquals(25.0, strategy.calculateCost(p), "Standard shipping cost should be weight * 2.5");
    }

    @Test
    public void testExpressShipping() {
        ShippingStrategy strategy = new ExpressShipping();
        Package p = new Package(10.0);
        assertEquals(35.0, strategy.calculateCost(p), "Express shipping cost should be weight * 3.5");
    }
}