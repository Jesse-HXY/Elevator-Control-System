package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class DoorClose implements State {
    private ElevatorController elevatorController;
    public DoorClose(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    @Override
    public void prepare() {
        if(elevatorController.getDownList().size() == 0 && elevatorController.getUpList().size() == 0){
            elevatorController.setCurrentState(elevatorController.getIdle());
            elevatorController.setNotice("Idle");
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
    public void moving() {

    }

    @Override
    public void openDoor() {
        elevatorController.setNotice("Door Open");
        elevatorController.setCurrentState(elevatorController.getDoorOpen());
    }

    @Override
    public void closeDoor() {
        elevatorController.setNotice("Door already close");
    }

}
