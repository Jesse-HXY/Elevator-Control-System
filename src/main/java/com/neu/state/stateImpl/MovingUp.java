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
        /*elevatorController.setNotice("Moving");
        int tempFloorNum = elevatorController.getCurrentFloorNum();
        int aimFloorNum = elevatorController.getUpList().get(0);
        while(tempFloorNum != aimFloorNum){
            tempFloorNum++;
            elevatorController.setCurrentFloorNum(tempFloorNum);
        }
        elevatorController.getUpList().remove(0);
        elevatorController.setCurrentState(elevatorController.getStop());
        elevatorController.setNotice("arrived");*/
        int tempFloorNum = elevatorController.getCurrentFloorNum() + 1;
        elevatorController.setCurrentFloorNum(tempFloorNum);
        int aimFloorNum = elevatorController.getUpList().get(0);
        if(tempFloorNum == aimFloorNum){
            elevatorController.getUpList().remove(0);
            elevatorController.setCurrentState(elevatorController.getStop());
            //elevatorController.setNotice("arrived");
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
