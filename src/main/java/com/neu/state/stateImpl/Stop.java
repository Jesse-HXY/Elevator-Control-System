package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class Stop implements State {
    private ElevatorController elevatorController;
    public Stop(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    @Override
    public void prepare() {

    }

    @Override
    public void moving() {
        elevatorController.setNotice("open door first");
    }

    @Override
    public void openDoor() {
        elevatorController.setNotice("Door already close");
        elevatorController.setCurrentState(elevatorController.getDoorOpen());
    }

    @Override
    public void closeDoor() {
        elevatorController.setNotice("Door open");
    }

    @Override
    public void printCurrentState() {
        System.out.println("Stop");
    }
}
