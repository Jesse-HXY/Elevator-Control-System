package com.neu.listener;


public interface DoorSensorListener {
    /**
     * change the door state to door open
     */
    void doorOpen();
    /**
     * change the door state to door close
     */
    void doorClosed();
    /**
     * change the door state to door block
     */
    void doorBlocked();
}
