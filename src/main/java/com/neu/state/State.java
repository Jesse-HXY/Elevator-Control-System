package com.neu.state;

public interface State {
    void prepare();
    void moving();
    void openDoor();
    void closeDoor();
    void printCurrentState();
}
