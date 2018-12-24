package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class MovingDown implements State {
    private ElevatorController elevatorController;
    public MovingDown(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    @Override
    public void goUp() {

    }

    @Override
    public void goDown() {
        int floorNum = elevatorController.getCurrentFloorNum();
        while (floorNum > elevatorController.getAimFloorNum()){
            floorNum--;
            elevatorController.setCurrentFloorNum(floorNum);
        }
        elevatorController.setCurrentState(elevatorController.getStop());
    }

    @Override
    public void openDoor() {

    }

    @Override
    public void closeDoor() {

    }
}
