package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class Idle implements State {
    private ElevatorController elevatorController;
    public Idle(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }
}
