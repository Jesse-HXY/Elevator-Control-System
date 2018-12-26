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
    private double currentFloorNum;
    private boolean isReached;
    private List<Double> upList;
    private List<Double> downList;
    private double aimFloorNum;
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

    public boolean moving() {
        currentState.moving();
        return (currentFloorNum != aimFloorNum);
    }

    public void blockButtonPressed() {
        if (currentState == idle || currentState == doorClose || currentState == doorOpen) {
            currentState = doorBlocked;
        }
    }

    public void floorReached() {
        if ((int) currentFloorNum == currentFloorNum) {
            isReached = true;
        } else {
            isReached = false;
        }
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

    public void floorButtonPressed(double floorNum) {
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


    public State getDoorClose() {
        return doorClose;
    }


    public State getDoorOpen() {
        return doorOpen;
    }


    public State getIdle() {
        return idle;
    }


    public State getMovingDown() {
        return movingDown;
    }


    public State getMovingUp() {
        return movingUp;
    }


    public State getStop() {
        return stop;
    }


    public State getCurrentState() {
        return currentState;
    }

    public double getCurrentFloorNum() {
        return currentFloorNum;
    }

    public void setCurrentFloorNum(double currentFloorNum) {
        this.currentFloorNum = currentFloorNum;
    }

    public boolean isReached() {
        return isReached;
    }

    public void setReached(boolean reached) {
        isReached = reached;
    }

    public double CalcualateAimFloorNum() {
        if (isUp && upList.size() != 0) {
            aimFloorNum = upList.get(0);
        } else if (!isUp && downList.size() != 0) {
            aimFloorNum = downList.get(downList.size() - 1);
        }
        return aimFloorNum;
    }

    public List<Double> getUpList() {
        return upList;
    }

    public List<Double> getDownList() {
        return downList;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }


}
