package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class MovingUp implements State {
    private ElevatorController elevatorController;
    public MovingUp(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    @Override
    public void goUp() {
        int floorNum = elevatorController.getCurrentFloorNum();
        while(floorNum < elevatorController.getAimFloorNum()){
            floorNum--;
            elevatorController.setCurrentFloorNum(floorNum);
        }
        elevatorController.setCurrentState(elevatorController.getStop());
    }

    @Override
    public void goDown() {

    }

    @Override
    public void openDoor() {

    }

    @Override
    public void closeDoor() {

    }
}
