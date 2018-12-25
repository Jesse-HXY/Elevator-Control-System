package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class MovingDown implements State {
    private ElevatorController elevatorController;
    public MovingDown(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }


    @Override
    public void moving() {
        int listSize = elevatorController.getDownList().size();
        int aimFloorNum = elevatorController.getDownList().get(listSize);
        int tempFloorNum = elevatorController.getCurrentFloorNum();
        while(tempFloorNum != aimFloorNum){
            tempFloorNum--;
            elevatorController.setCurrentFloorNum(tempFloorNum);
        }
        elevatorController.getDownList().remove(listSize);
        elevatorController.setCurrentState(elevatorController.getStop());
    }

    @Override
    public void openDoor() {

    }

    @Override
    public void closeDoor() {

    }
}
