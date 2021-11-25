package Braking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BrakeManagerTest {
    @Test
    public void shouldReturnParked() {
        BrakeManager.getInstance().parking();
        assertEquals(true, BrakeManager.getInstance().getIsParking());
    }

    @Test
    public void shouldReturnParkedFalse() {
        BrakeManager.getInstance().drive();
        assertEquals(false, BrakeManager.getInstance().getIsParking());
    }

    @Test
    public void shouldReturnTotalPercentage() {
        BrakeManager.getInstance().applyBrakes(-10);
        assertEquals(0, BrakeManager.getInstance().getBrakePowerPercentage());

        BrakeManager.getInstance().applyBrakes(0);
        assertEquals(0, BrakeManager.getInstance().getBrakePowerPercentage());
    }

    @Test
    public void shouldReturnZeroBrakingForce() {
        BrakeManager.getInstance().applyBrakes(120);
        assertEquals(100, BrakeManager.getInstance().getBrakePowerPercentage());

        BrakeManager.getInstance().applyBrakes(100);
        assertEquals(100, BrakeManager.getInstance().getBrakePowerPercentage());
    }

    @Test
    public void shouldApplyTheBrakes() {
        BrakeManager.getInstance().applyBrakes(17.5);
        assertEquals(17.5, BrakeManager.getInstance().getBrakePowerPercentage());
    }
}