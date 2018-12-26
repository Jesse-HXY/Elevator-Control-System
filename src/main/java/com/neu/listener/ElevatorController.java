package com.neu.listener;

import com.neu.state.State;
import com.neu.state.stateImpl.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElevatorController implements DoorSensorListener, ElevatorPanelListener, FloorSensorListener {
    private static ElevatorController elevatorController;
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
    private List<Integer> upList;
    private List<Integer> downList;
    private int aimFloorNum;
    private int currentGap;
    private boolean isUp;
    private String notice;
    private String doorState;

    public void openButtonPressed() {
        currentState.openDoor();
    }

    public void closedButtonPressed() {
        CalcualateAimFloorNum();
        currentState.closeDoor();
        currentState.prepare();
    }

    public void movinginGap(){
        if(isUp){
            currentGap = currentFloorNum;
        }else{
            currentGap = currentFloorNum - 1;
        }
    }

    public boolean moving(){
        currentState.moving();
        currentGap = -1;
        return (currentFloorNum != aimFloorNum);
    }

    public void floorReached() {

    }

    public int getCurrentGap() {
        return currentGap;
    }

    public void setCurrentGap(int currentGap) {
        this.currentGap = currentGap;
    }

    public void doorOpen() {
        doorState = "open";
    }

    public void doorClosed() {
        doorState = "close";
    }

    public void doorBlocked() {
        doorState = "blocked";
    }

    public void print(){
        currentState.printCurrentState();
    }

    public void floorButtonPressed(int floorNum) {
        if (floorNum > currentFloorNum) {
            upList.add(floorNum);
            Collections.sort(upList);
        } else {
            downList.add(floorNum);
            Collections.sort(downList);
        }
    }

    private ElevatorController() {
        this.currentFloorNum = 1;
        this.aimFloorNum = 1;
        this.currentGap = -1;
        this.doorState = "closed";
        this.isReached = false;
        this.isUp = true;
        this.upList = new ArrayList<>();
        this.downList = new ArrayList<>();
        this.doorBlocked = new DoorBlocked(this);
        this.doorClose = new DoorClose(this);
        this.doorOpen = new DoorOpen(this);
        this.idle = new Idle(this);
        this.movingDown = new MovingDown(this);
        this.movingUp = new MovingUp(this);
        this.stop = new Stop(this);
        this.currentState = idle;
    }

    public static synchronized ElevatorController getInstance() {
        if (elevatorController == null) {
            elevatorController = new ElevatorController();
        }
        return elevatorController;
    }

    public String getDoorState() {
        return doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setCurrentState(State state) {
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

    public int CalcualateAimFloorNum() {
        if(isUp && upList.size() != 0){
            aimFloorNum = upList.get(0);
        }else if(!isUp && downList.size() != 0){
            aimFloorNum = downList.get(downList.size() - 1);
        }
        return aimFloorNum;
    }

    public void setAimFloorNum(int aimFloorNum) {
        this.aimFloorNum = aimFloorNum;
    }

    public List<Integer> getUpList() {
        return upList;
    }

    public void setUpList(List<Integer> upList) {
        this.upList = upList;
    }

    public List<Integer> getDownList() {
        return downList;
    }

    public void setDownList(List<Integer> downList) {
        this.downList = downList;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }


}
