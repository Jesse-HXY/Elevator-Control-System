package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class Stop implements State {
    private ElevatorController elevatorController;
    public Stop(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }
}
