package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class DoorClose implements State {
    private ElevatorController elevatorController;
    public DoorClose(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }
}
