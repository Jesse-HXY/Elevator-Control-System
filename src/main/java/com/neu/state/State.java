package com.neu.state;

public interface State {
    void moving();
    void openDoor();
    void closeDoor();
    void printCurrentState();
}
