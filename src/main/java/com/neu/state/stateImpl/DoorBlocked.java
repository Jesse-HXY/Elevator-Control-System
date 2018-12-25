package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class DoorBlocked implements State {
    private ElevatorController elevatorController;
    public DoorBlocked(ElevatorController elevatorController){
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

    }

    @Override
    public void printCurrentState() {
        System.out.println("DoorBlocked");
    }
}
