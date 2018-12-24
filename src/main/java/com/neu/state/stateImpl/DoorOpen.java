package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class DoorOpen implements State {
    private ElevatorController elevatorController;
    public DoorOpen(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    @Override
    public void goUp() {
        System.out.println("the door is open. It can't run!!!");
    }

    @Override
    public void goDown() {
        System.out.println("the door is open. It can't run!!!");

    }

    @Override
    public void openDoor() {

    }

    @Override
    public void closeDoor() {
        elevatorController.setCurrentState(elevatorController.getDoorClose());
    }
}
