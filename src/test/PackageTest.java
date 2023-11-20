package test;

import main.ExpressShipping;
import main.Package;
import main.PackageState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PackageTest {
    @Test
    public void testCalculateShippingCost() {
        Package p = new Package(10.0);
        assertEquals(25.0, p.calculateShippingCost(), "Standard shipping cost should be weight * 2.5");

        p.setStrategy(new ExpressShipping());
        assertEquals(35.0, p.calculateShippingCost(), "Express shipping cost should be weight * 3.5");
    }
}