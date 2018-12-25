package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class DoorOpen implements State {
    private ElevatorController elevatorController;
    public DoorOpen(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }


    @Override
    public void moving() {

    }

    @Override
    public void openDoor() {

    }

    @Override
    public void closeDoor() {
        if(false){
            elevatorController.setCurrentState(elevatorController.getDoorBlocked());
        }
        else {
            elevatorController.setCurrentState(elevatorController.getDoorClose());
        }
    }

    @Override
    public void printCurrentState() {
        System.out.println("DoorOpen");
    }
}
