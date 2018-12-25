package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class DoorOpen implements State {
    private ElevatorController elevatorController;
    public DoorOpen(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }


    @Override
    public void prepare() {

    }

    @Override
    public void moving() {
        elevatorController.setNotice("Door open");
    }

    @Override
    public void openDoor() {
        elevatorController.setNotice("Door already open");
    }

    @Override
    public void closeDoor() {
        if(false){
            elevatorController.setCurrentState(elevatorController.getDoorBlocked());
        }
        else {
            elevatorController.setNotice("Door closed.");
            elevatorController.doorClosed();
            elevatorController.setCurrentState(elevatorController.getDoorClose());
        }
    }

    @Override
    public void printCurrentState() {
        System.out.println("DoorOpen");
    }
}
