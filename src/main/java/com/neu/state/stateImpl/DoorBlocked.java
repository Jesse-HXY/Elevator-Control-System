package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class DoorBlocked implements State {
    private ElevatorController elevatorController;
    public DoorBlocked(ElevatorController elevatorController){
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

    }

    @Override
    public void closeDoor() {

    }
}
