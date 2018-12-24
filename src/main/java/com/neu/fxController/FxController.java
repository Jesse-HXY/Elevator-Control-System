package com.neu.fxController;


import com.neu.listener.ElevatorController;
import com.neu.sensor.DoorSensor;
import com.neu.sensor.ElevatorPanel;
import com.neu.sensor.FloorSensor;
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

    private  DoorSensor doorSensor = new DoorSensor();
    private  ElevatorPanel elevatorPanel = new ElevatorPanel();
    private  FloorSensor floorSensor = new FloorSensor();


    @FXML
    public void openButtonAction(ActionEvent event) {
        elevatorPanel.getListeners().get(0).openButtonPressed();
    }

    @FXML
    public void closeButtonAction(ActionEvent event) {
        elevatorPanel.getListeners().get(0).closedButtonPressed();
    }

    @FXML
    public void oneButtonAction(ActionEvent event) {
        oneButton.setStyle("-fx-background-color: red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(1);
    }

    @FXML
    public void twoButtonAction(ActionEvent event) {
        twoButton.setStyle("-fx-background-color: red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(2);
    }

    @FXML
    public void threeButtonAction(ActionEvent event) {
        threeButton.setStyle("-fx-background-color: red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(3);
    }

    @FXML
    public void fourButtonAction(ActionEvent event) {
        fourButton.setStyle("-fx-background-color: red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(4);
    }

    @FXML
    public void fiveButtonAction(ActionEvent event) {
        fiveButton.setStyle("-fx-background-color: red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(5);
    }

    @FXML
    public void sixButtonAction(ActionEvent event) {
        sixButton.setStyle("-fx-background-color: red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(6);
    }


}
