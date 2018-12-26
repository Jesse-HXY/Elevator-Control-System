package com.neu.fxController;

import com.neu.listener.ElevatorController;
import com.neu.sensor.DoorSensor;
import com.neu.sensor.ElevatorPanel;
import com.neu.sensor.FloorSensor;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class FxController {
    @FXML
    private Button openButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Label notice;
    @FXML
    private Label oneFloor;
    @FXML
    private Label twoFloor;
    @FXML
    private Label threeFloor;
    @FXML
    private Label fourFloor;
    @FXML
    private Label fiveFloor;
    @FXML
    private Label sixFloor;
    @FXML
    private Label oneGap;
    @FXML
    private Label twoGap;
    @FXML
    private Label threeGap;
    @FXML
    private Label fourGap;
    @FXML
    private Label fiveGap;
    @FXML
    private Label oneDoor;
    @FXML
    private Label twoDoor;
    @FXML
    private Label threeDoor;
    @FXML
    private Label fourDoor;
    @FXML
    private Label fiveDoor;
    @FXML
    private Label sixDoor;

    private DoorSensor doorSensor = new DoorSensor();
    private ElevatorPanel elevatorPanel = new ElevatorPanel();
    private FloorSensor floorSensor = new FloorSensor();
    private ElevatorController elevatorController = ((ElevatorController) (elevatorPanel.getListeners().get(0)));


    @FXML
    public void openButtonAction(ActionEvent event) {
        elevatorPanel.getListeners().get(0).openButtonPressed();
        elevatorController.print();
        setNotice();
        updateState();
    }

    @FXML
    public void closeButtonAction(ActionEvent event) {
        elevatorPanel.getListeners().get(0).closedButtonPressed();
        new Thread(() -> {
            while (elevatorController.getCurrentFloorNum() != elevatorController.CalcualateAimFloorNum() && elevatorController.getCurrentState() != elevatorController.getStop()) {
                try {
                    //System.out.println(elevatorController.getCurrentGap());
                    Thread.sleep(1000);
                    //System.out.println(elevatorController.getCurrentGap());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    elevatorController.movinginGap();
                    Platform.runLater(() ->  updateState());
                    elevatorController.moving();
                    elevatorController.setCurrentGap(-1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    updateState();
                    setNotice();
                    setColorBack();
                });
            }
            Platform.runLater(() -> notice.setText("Arrived"));
        }).start();

    }

    @FXML
    public void oneButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentFloorNum() == 1) {
            notice.setText("you are already in floor 1");
            return;
        }
        oneButton.setStyle("-fx-border-color:red");
        notice.setText("Floor one selected");
        elevatorPanel.getListeners().get(0).floorButtonPressed(1);
    }

    @FXML
    public void twoButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentFloorNum() == 2) {
            notice.setText("you are already in floor 2");
            return;
        }
        twoButton.setStyle("-fx-border-color:red");
        notice.setText("Floor two selected");
        elevatorController.floorButtonPressed(2);
    }

    @FXML
    public void threeButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentFloorNum() == 3) {
            notice.setText("you are already in floor 3");
            return;
        }
        threeButton.setStyle("-fx-border-color:red");
        notice.setText("Floor three selected");
        elevatorController.floorButtonPressed(3);
    }

    @FXML
    public void fourButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentFloorNum() == 4) {
            notice.setText("you are already in floor 4");
            return;
        }
        fourButton.setStyle("-fx-border-color:red");
        notice.setText("Floor four selected");
        elevatorController.floorButtonPressed(4);
    }

    @FXML
    public void fiveButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentFloorNum() == 5) {
            notice.setText("you are already in floor 5");
            return;
        }
        fiveButton.setStyle("-fx-border-color:red");
        notice.setText("Floor five selected");
        elevatorController.floorButtonPressed(5);
    }

    @FXML
    public void sixButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentFloorNum() == 6) {
            notice.setText("you are already in floor 6");
            return;
        }
        sixButton.setStyle("-fx-border-color:red");
        notice.setText("Floor six selected");
        elevatorController.floorButtonPressed(6);
    }

    public void setNotice() {
        notice.setText(elevatorController.getNotice());
    }

    public void setColorBack() {
        switch (elevatorController.getCurrentFloorNum()) {
            case 1:
                oneButton.setStyle("-fx-border-color:null");
                break;
            case 2:
                twoButton.setStyle("-fx-border-color:null");
                break;
            case 3:
                threeButton.setStyle("-fx-border-color:null");
                break;
            case 4:
                fourButton.setStyle("-fx-border-color:null");
                break;
            case 5:
                fiveButton.setStyle("-fx-border-color:null");
                break;
            case 6:
                sixButton.setStyle("-fx-border-color:null");
                break;
        }
    }


    public void updateState() {
        int floorNum = elevatorController.getCurrentFloorNum();
        int gapNum = elevatorController.getCurrentGap();
        String doorState = elevatorController.getDoorState();
        System.out.println(gapNum);
        if(gapNum != -1){
            switch (gapNum) {
                case 1:
                    oneFloor.setText("");
                    oneGap.setText("*****");
                    twoFloor.setText("");
                    oneDoor.setText(doorState);
                    twoDoor.setText(doorState);
                    break;
                case 2:
                    twoFloor.setText("");
                    twoGap.setText("*****");
                    threeFloor.setText("");
                    twoDoor.setText(doorState);
                    threeDoor.setText(doorState);
                    break;
                case 3:
                    threeFloor.setText("");
                    threeGap.setText("*****");
                    fourFloor.setText("");
                    threeDoor.setText(doorState);
                    fourDoor.setText(doorState);
                    break;
                case 4:
                    fourFloor.setText("");
                    fourGap.setText("*****");
                    fiveFloor.setText("");
                    fourDoor.setText(doorState);
                    fiveDoor.setText(doorState);
                    break;
                case 5:
                    fiveFloor.setText("");
                    fourGap.setText("*****");
                    sixFloor.setText("");
                    fiveDoor.setText(doorState);
                    sixDoor.setText(doorState);
                    break;
            }
        }else {
            switch (floorNum) {
                case 1:
                    oneFloor.setText("*****");
                    oneGap.setText("");
                    oneDoor.setText(doorState);
                    twoDoor.setText("");
                    break;
                case 2:
                    oneGap.setText("");
                    twoFloor.setText("*****");
                    twoGap.setText("");
                    oneDoor.setText("");
                    twoDoor.setText(doorState);
                    threeDoor.setText("");
                    break;
                case 3:
                    twoGap.setText("");
                    threeFloor.setText("*****");
                    threeGap.setText("");
                    twoDoor.setText("");
                    threeDoor.setText(doorState);
                    fourDoor.setText("");
                    break;
                case 4:
                    threeGap.setText("");
                    fourFloor.setText("*****");
                    fourGap.setText("");
                    threeDoor.setText("");
                    fourDoor.setText(doorState);
                    fiveDoor.setText("");
                    break;
                case 5:
                    fourGap.setText("");
                    fiveFloor.setText("*****");
                    fiveGap.setText("");
                    fourDoor.setText("");
                    fiveDoor.setText(doorState);
                    sixDoor.setText("");
                    break;
                case 6:
                    fiveGap.setText("");
                    sixFloor.setText("*****");
                    fiveDoor.setText("");
                    sixDoor.setText(doorState);
                    break;
            }

        }
    }
}
