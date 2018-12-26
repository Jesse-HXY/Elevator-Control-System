package com.neu.state.stateImpl;

import com.neu.listener.ElevatorController;
import com.neu.state.State;

public class MovingUp implements State {
    private ElevatorController elevatorController;
    public MovingUp(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }


    @Override
    public void prepare() {

    }

    @Override
    public void moving() {
        elevatorController.setNotice("Moving up");
        double tempFloorNum = elevatorController.getCurrentFloorNum() + 0.5;
        elevatorController.setCurrentFloorNum(tempFloorNum);
        double aimFloorNum = elevatorController.getUpList().get(0);
        if(tempFloorNum == aimFloorNum){
            elevatorController.getUpList().remove(0);
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

    @Override
    public void printCurrentState() {
        System.out.println("MovingUp");
    }
}
