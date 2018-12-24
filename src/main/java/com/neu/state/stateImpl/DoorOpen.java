package com.neu.state.stateImpl;

import com.neu.ElevatorController;
import com.neu.state.State;

public class DoorOpen implements State {
    private ElevatorController elevatorController;
    public DoorOpen(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }
}
