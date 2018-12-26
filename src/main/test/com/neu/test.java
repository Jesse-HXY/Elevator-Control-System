package com.neu;

import com.neu.listener.ElevatorController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    /*@Test
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
    }*/

    @Test
    public void testPressnNumberButton(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.setCurrentFloorNum(3);
        elevatorController.floorButtonPressed(4);
        elevatorController.floorButtonPressed(5);
        elevatorController.floorButtonPressed(1);
        elevatorController.floorButtonPressed(2);
        List<Double> upList = new ArrayList<>();
        List<Double> downList = new ArrayList<>();
        downList.add(1.0);
        downList.add(2.0);
        upList.add(4.0);
        upList.add(5.0);
        assertEquals(upList, elevatorController.getUpList());
        assertEquals(downList, elevatorController.getDownList());
    }

    @Test
    public void testOpenPress(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.openButtonPressed();
        assertEquals(elevatorController.getDoorOpen(), elevatorController.getCurrentState());
    }

    @Test
    public void testClosePress(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.floorButtonPressed(4);
        elevatorController.openButtonPressed();
        elevatorController.closedButtonPressed();
        assertEquals(elevatorController.getMovingUp(), elevatorController.getCurrentState());
    }

    @Test
    public void testMoving(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.floorButtonPressed(2);
        elevatorController.openButtonPressed();
        elevatorController.closedButtonPressed();
        assertEquals(true, elevatorController.moving());
        assertEquals(false, elevatorController.moving());
    }

    @Test
    public void testReached(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.setCurrentFloorNum(2);
        elevatorController.floorReached();
        assertEquals(true, elevatorController.isReached());
        elevatorController.setCurrentFloorNum(2.5);
        elevatorController.floorReached();
        assertEquals(false, elevatorController.isReached());
    }

}
