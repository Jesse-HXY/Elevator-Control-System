package com.neu;

import com.neu.listener.ElevatorController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    @Test
    public void testmoving() {
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.floorButtonPressed(3);
        elevatorController.floorButtonPressed(5);
        elevatorController.closedButtonPressed();
        //assertEquals(elevatorController.getCurrentState(),elevatorController.getIdle());
        assertEquals(3, elevatorController.getCurrentFloorNum());
        elevatorController.floorButtonPressed(1);
        elevatorController.openButtonPressed();
        elevatorController.closedButtonPressed();
        elevatorController.closedButtonPressed();
        assertEquals(5, elevatorController.getCurrentFloorNum());
        elevatorController.openButtonPressed();
        elevatorController.closedButtonPressed();
        assertEquals(1, elevatorController.getCurrentFloorNum());
    }

}
