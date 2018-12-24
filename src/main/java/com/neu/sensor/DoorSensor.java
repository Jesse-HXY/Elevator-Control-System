package com.neu.sensor;

import com.neu.listener.DoorSensorListener;

import java.util.List;

public class DoorSensor {
    private List<DoorSensorListener> listeners;
    public void addDoorSensorListener(DoorSensorListener listener){
        listeners.add(listener);
    }
}
