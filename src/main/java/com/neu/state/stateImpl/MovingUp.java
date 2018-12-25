package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class MovingUp implements State {
    private ElevatorController elevatorController;
    public MovingUp(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }


    @Override
    public void moving() {
        int tempFloorNum = elevatorController.getCurrentFloorNum();
        int aimFloorNum = elevatorController.getUpList().get(0);
        while(tempFloorNum != aimFloorNum){
            tempFloorNum++;
            elevatorController.setCurrentFloorNum(tempFloorNum);
        }
        elevatorController.getUpList().remove(0);
        elevatorController.setCurrentState(elevatorController.getStop());
    }

    @Override
    public void openDoor() {

    }

    @Override
    public void closeDoor() {

    }

    @Override
    public void printCurrentState() {
        System.out.println("MovingUp");
    }
}
