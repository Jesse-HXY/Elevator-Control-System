package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class DoorClose implements State {
    private ElevatorController elevatorController;
    public DoorClose(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    @Override
    public void goUp() {
        if(elevatorController.getCurrentFloorNum() <= 6) {
            elevatorController.setCurrentState(elevatorController.getMovingUp());
        }
        else{
            System.out.println("can't go up!!!");
        }
    }

    @Override
    public void goDown() {
        if(elevatorController.getCurrentFloorNum() >= 0){
            elevatorController.setCurrentState(elevatorController.getMovingDown());
        }
        else {
            System.out.println("can't go down");
        }

    }

    @Override
    public void openDoor() {
        elevatorController.setCurrentState(elevatorController.getDoorOpen());
    }

    @Override
    public void closeDoor() {

    }
}
