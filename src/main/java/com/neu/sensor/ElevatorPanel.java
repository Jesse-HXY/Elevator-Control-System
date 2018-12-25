package com.neu.sensor;


import com.neu.listener.ElevatorController;
import com.neu.listener.ElevatorPanelListener;

import java.util.ArrayList;
import java.util.List;

public class ElevatorPanel {
    private List<ElevatorPanelListener> listeners;

    public List<ElevatorPanelListener> getListeners() {
        return listeners;
    }

    public void addElevatorPanelListener(ElevatorPanelListener listener) {
        listeners.add(listener);
    }

    public ElevatorPanel() {
        listeners = new ArrayList<>();
        listeners.add(ElevatorController.getInstance());
    }

}
