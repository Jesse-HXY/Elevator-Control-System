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
    public ElevatorController(){
        currentFloorNum = 1;
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

    public void floorButtonPressed(int floorNum){

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
