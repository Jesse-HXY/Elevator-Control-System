package com.neu.sensor;

import com.neu.listener.FloorSensorListener;

import java.util.List;

public class FloorSensor {
    private List<FloorSensorListener> listeners;
    public void addFloorSensorListener(FloorSensorListener listener){
        listeners.add(listener);
    }
}
