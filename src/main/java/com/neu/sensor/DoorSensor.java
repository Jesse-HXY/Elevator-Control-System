package com.neu.sensor;

import com.neu.listener.DoorSensorListener;
import com.neu.listener.ElevatorController;

import java.util.ArrayList;
import java.util.List;

public class DoorSensor {
    private List<DoorSensorListener> listeners;

    public List<DoorSensorListener> getListeners() {
        return listeners;
    }

    public void addDoorSensorListener(DoorSensorListener listener){
        listeners.add(listener);
    }

    public DoorSensor(){
        listeners = new ArrayList<>();
        listeners.add(ElevatorController.getInstance());
    }
}
