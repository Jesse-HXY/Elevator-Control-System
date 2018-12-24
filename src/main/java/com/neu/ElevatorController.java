package com.neu;

import com.neu.state.State;
import com.neu.state.stateImpl.*;

public class ElevatorController {
    private State doorBlocked;
    private State doorClose;
    private State doorOpen;
    private State idle;
    private State movingDown;
    private State movingUp;
    private State stop;
    private State currentState;

    private int currentFloorNum;
    private boolean isReached;
    private int aimFloorNum;
    public ElevatorController(){
        currentFloorNum = 1;
        aimFloorNum = 1;
        isReached = false;
        doorBlocked = new DoorBlocked(this);
        doorClose = new DoorClose(this);
        doorOpen = new DoorOpen(this);
        idle = new Idle(this);
        movingDown = new MovingDown(this);
        movingUp = new MovingUp(this);
        stop = new Stop(this);
        currentState = idle;
    }

    public void setCurrentState(State state){
        this.currentState = state;
    }

    public State getDoorBlocked() {
        return doorBlocked;
    }

    public void setDoorBlocked(State doorBlocked) {
        this.doorBlocked = doorBlocked;
    }

    public State getDoorClose() {
        return doorClose;
    }

    public void setDoorClose(State doorClose) {
        this.doorClose = doorClose;
    }

    public State getDoorOpen() {
        return doorOpen;
    }

    public void setDoorOpen(State doorOpen) {
        this.doorOpen = doorOpen;
    }

    public State getIdle() {
        return idle;
    }

    public void setIdle(State idle) {
        this.idle = idle;
    }

    public State getMovingDown() {
        return movingDown;
    }

    public void setMovingDown(State movingDown) {
        this.movingDown = movingDown;
    }

    public State getMovingUp() {
        return movingUp;
    }

    public void setMovingUp(State movingUp) {
        this.movingUp = movingUp;
    }

    public State getStop() {
        return stop;
    }

    public void setStop(State stop) {
        this.stop = stop;
    }

    public State getCurrentState() {
        return currentState;
    }

    public int getCurrentFloorNum() {
        return currentFloorNum;
    }

    public void setCurrentFloorNum(int currentFloorNum) {
        this.currentFloorNum = currentFloorNum;
    }

    public boolean isReached() {
        return isReached;
    }

    public void setReached(boolean reached) {
        isReached = reached;
    }

    public void floorButtonPressed(int floorNum){
        aimFloorNum = floorNum;
    }

    public int getAimFloorNum() {
        return aimFloorNum;
    }

    public void setAimFloorNum(int aimFloorNum) {
        this.aimFloorNum = aimFloorNum;
    }

    public void openButtonPressed(){

    }
    public void closedButtonPressed(){

    }
    public void floorReached(){

    }
    public void doorOpen(){

    }
    public void doorClosed(){

    }
    public void doorBlocked(){

    }

}
