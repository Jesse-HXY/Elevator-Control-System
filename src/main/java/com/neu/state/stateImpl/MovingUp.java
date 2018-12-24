package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class MovingUp implements State {
    private ElevatorController elevatorController;
    public MovingUp(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }
}
