package com.neu.sensor;


import com.neu.listener.ElevatorPanelListener;

import java.util.List;

public class ElevatorPanel {
    private List<ElevatorPanelListener> listeners;
    public void addElevatorPanelListener(ElevatorPanelListener listener){
        listeners.add(listener);
    }
}
