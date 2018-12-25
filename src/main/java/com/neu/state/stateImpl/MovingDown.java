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
        /*
        int listSize = elevatorController.getDownList().size() - 1;
        int aimFloorNum = elevatorController.getDownList().get(listSize);
        int tempFloorNum = elevatorController.getCurrentFloorNum();
        while(tempFloorNum != aimFloorNum){
            tempFloorNum--;
            elevatorController.setCurrentFloorNum(tempFloorNum);
        }
        elevatorController.getDownList().remove(listSize);
        elevatorController.setCurrentState(elevatorController.getStop());
        elevatorController.setNotice("arrived");*/
        int tempFloorNum = elevatorController.getCurrentFloorNum() - 1;
        elevatorController.setCurrentFloorNum(tempFloorNum);
        int listSize = elevatorController.getDownList().size() - 1;
        int aimFloorNum = elevatorController.CalcualateAimFloorNum();
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

    @Override
    public void printCurrentState() {
        System.out.println("MovingDown");
    }
}
