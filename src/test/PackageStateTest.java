package test;

import main.DeliveredState;
import main.InTransitState;
import main.PackageAcceptedState;
import main.PackageState;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class PackageStateTest {

    @Test
    public void testAcceptedState() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PackageState state = new PackageAcceptedState();
        state.printStatus();

        assertEquals("The package is accepted." + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testInTransitState() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PackageState state = new InTransitState();
        state.printStatus();
        assertEquals("The package is in-transit." + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testDeliveredState() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PackageState state = new DeliveredState();
        state.printStatus();

        assertEquals("The package has been delivered." + System.lineSeparator(), outContent.toString());
    }



}
