package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class Stop implements State {
    private ElevatorController elevatorController;
    public Stop(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    @Override
    public void moving() {

    }

    @Override
    public void openDoor() {
        elevatorController.setCurrentState(elevatorController.getDoorOpen());
    }

    @Override
    public void closeDoor() {

    }

    @Override
    public void printCurrentState() {
        System.out.println("Stop");
    }
}
