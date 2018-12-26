package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class DoorBlocked implements State {
    private ElevatorController elevatorController;
    public DoorBlocked(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }


    @Override
    public void prepare() {
    }

    @Override
    public void moving() {

    }

    @Override
    public void openDoor() {
        elevatorController.setNotice("Door already open");
    }

    @Override
    public void closeDoor() {
        elevatorController.setNotice("Something is blocking.");
    }

}
