package com.neu.sensor;

import com.neu.listener.ElevatorController;
import com.neu.listener.FloorSensorListener;

import java.util.ArrayList;
import java.util.List;

public class FloorSensor {
    private List<FloorSensorListener> listeners;

    public List<FloorSensorListener> getListeners() {
        return listeners;
    }

    public void addFloorSensorListener(FloorSensorListener listener){
        listeners.add(listener);
    }

    public FloorSensor(){
        listeners = new ArrayList<>();
        listeners.add(ElevatorController.getInstance());
    }
}
