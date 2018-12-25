package com.neu;

import com.neu.listener.ElevatorController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    @Test
    public void testmoving() {
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.floorButtonPressed(3);
        elevatorController.closedButtonPressed();
        //assertEquals(elevatorController.getCurrentState(),elevatorController.getIdle());
        assertEquals(3, elevatorController.getCurrentFloorNum());
    }

}
