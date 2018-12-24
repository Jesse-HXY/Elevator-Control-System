package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class Idle implements State {
    private ElevatorController elevatorController;
    public Idle(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }


    @Override
    public void moving() {

    }

    @Override
    public void openDoor() {
        elevatorController.setCurrentState(elevatorController.getDoorOpen());
        elevatorController.getCurrentState().openDoor();
    }

    @Override
    public void closeDoor() {
        elevatorController.setNotice("The door is closed.");
    }
}
