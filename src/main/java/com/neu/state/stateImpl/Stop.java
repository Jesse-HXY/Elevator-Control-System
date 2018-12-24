package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class Stop implements State {
    private ElevatorController elevatorController;
    public Stop(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    @Override
    public void goUp() {

    }

    @Override
    public void goDown() {

    }

    @Override
    public void openDoor() {
        elevatorController.setCurrentState(elevatorController.getDoorOpen());
    }

    @Override
    public void closeDoor() {
        elevatorController.setCurrentState(elevatorController.getDoorClose());
    }
}
