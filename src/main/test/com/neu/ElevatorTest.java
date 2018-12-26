package com.neu;

import com.neu.listener.ElevatorController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElevatorTest {
    /**
     * a serious of action of pressing floor number button
     * @param elevatorController the elevator to press
     */
    public void pressAction(ElevatorController elevatorController){
        elevatorController.setCurrentFloorNum(3);
        elevatorController.floorButtonPressed(4);
        elevatorController.floorButtonPressed(5);
        elevatorController.floorButtonPressed(1);
        elevatorController.floorButtonPressed(2);
    }
    /**
     * test for the floorButtonPressed(double floorNum)
     */
    @Test
    public void testPressNumberButton(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        pressAction(elevatorController);
        List<Double> upList = new ArrayList<>();
        List<Double> downList = new ArrayList<>();
        downList.add(1.0);
        downList.add(2.0);
        upList.add(4.0);
        upList.add(5.0);
        assertEquals(upList, elevatorController.getUpList());
        assertEquals(downList, elevatorController.getDownList());
    }

    /**
     * test for the openButtonPressed()
     */
    @Test
    public void testOpenPress(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.openButtonPressed();
        assertEquals(elevatorController.getDoorOpen(), elevatorController.getCurrentState());
    }

    /**
     * test for closedButtonPressed()
     */
    @Test
    public void testClosePress(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.floorButtonPressed(4);
        elevatorController.openButtonPressed();
        elevatorController.closedButtonPressed();
        assertEquals(elevatorController.getMovingUp(), elevatorController.getCurrentState());
    }

    /**
     * test for moving()
     */
    @Test
    public void testMoving(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.floorButtonPressed(2);
        elevatorController.openButtonPressed();
        elevatorController.closedButtonPressed();
        assertEquals(true, elevatorController.moving());
        assertEquals(false, elevatorController.moving());
    }

    /**
     * test for floorReached()
     */
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

    /**
     * test for blockButtonPressed()
     */
    @Test
    public void testBlockedPress(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        elevatorController.blockButtonPressed();
        assertEquals(elevatorController.getDoorBlocked(), elevatorController.getCurrentState());
        elevatorController.setCurrentState(elevatorController.getDoorClose());
        elevatorController.blockButtonPressed();
        assertEquals(elevatorController.getDoorBlocked(), elevatorController.getCurrentState());
        elevatorController.setCurrentState(elevatorController.getDoorOpen());
        elevatorController.blockButtonPressed();
        assertEquals(elevatorController.getDoorBlocked(), elevatorController.getCurrentState());
        elevatorController.setCurrentState(elevatorController.getStop());
        elevatorController.blockButtonPressed();
        assertEquals(elevatorController.getStop(), elevatorController.getCurrentState());
    }

    /**
     * test for CalcualateAimFloorNum()
     */
    @Test
    public void testCalculateAimFloorNum(){
        ElevatorController elevatorController = ElevatorController.getInstance();
        pressAction(elevatorController);
        elevatorController.setUp(true);
        assertEquals(4, elevatorController.CalcualateAimFloorNum());
        elevatorController.setUp(false);
        assertEquals(2, elevatorController.CalcualateAimFloorNum());
    }
}
