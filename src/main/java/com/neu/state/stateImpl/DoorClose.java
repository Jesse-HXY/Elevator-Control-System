package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class DoorClose implements State {
    private ElevatorController elevatorController;
    public DoorClose(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    @Override
    public void moving() {
        if(elevatorController.getDownList().size() == 0 && elevatorController.getUpList().size() == 0){
            elevatorController.setCurrentState(elevatorController.getIdle());
        }
        else {
            if (elevatorController.isUp()) {
                if (elevatorController.getUpList().size() == 0) {
                    elevatorController.setCurrentState(elevatorController.getMovingDown());
                    elevatorController.setUp(false);
                } else {
                    elevatorController.setCurrentState(elevatorController.getMovingUp());
                }
            } else {
                if (elevatorController.getDownList().size() == 0) {
                    elevatorController.setCurrentState(elevatorController.getMovingUp());
                    elevatorController.setUp(true);
                } else {
                    elevatorController.setCurrentState(elevatorController.getMovingDown());
                }
            }
        }
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
        System.out.println("DoorClose");
    }
}
