package com.neu.state;

public interface State {
    /**
     * prepare for moving
     */
    void prepare();
    /**
     * elevator moving
     */
    void moving();
    /**
     * open the door
     */
    void openDoor();

    /**
     * close the door
     */
    void closeDoor();
}
