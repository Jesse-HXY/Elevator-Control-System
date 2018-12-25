package com.neu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    @Test
    public void testmoving() {
        ElevatorController elevatorController = new ElevatorController();
        elevatorController.floorButtonPressed(3);
        elevatorController.closedButtonPressed();
        //assertEquals(elevatorController.getCurrentState(),elevatorController.getIdle());
        assertEquals(3, elevatorController.getCurrentFloorNum());
    }

}
