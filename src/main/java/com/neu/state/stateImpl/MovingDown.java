package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class MovingDown implements State {
    private ElevatorController elevatorController;
    public MovingDown(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }


    @Override
    public void prepare() {

    }

    @Override
    public void moving() {
        elevatorController.setNotice("Moving down");
        double tempFloorNum = elevatorController.getCurrentFloorNum() - 0.5;
        elevatorController.setCurrentFloorNum(tempFloorNum);
        int listSize = elevatorController.getDownList().size() - 1;
        double aimFloorNum = elevatorController.CalcualateAimFloorNum();
        if(tempFloorNum == aimFloorNum){
            elevatorController.getDownList().remove(listSize);
            elevatorController.setCurrentState(elevatorController.getStop());
        }
    }

    @Override
    public void openDoor() {
        elevatorController.setNotice("Moving");
    }

    @Override
    public void closeDoor() {
        elevatorController.setNotice("Door already close");
    }

}
