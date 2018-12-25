package com.neu.fxController;

import com.neu.listener.ElevatorController;
import com.neu.sensor.DoorSensor;
import com.neu.sensor.ElevatorPanel;
import com.neu.sensor.FloorSensor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static java.lang.Thread.sleep;


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
        ((ElevatorController) (elevatorPanel.getListeners().get(0))).print();
        setNotice();
        updateState();
    }

    @FXML
    public void closeButtonAction(ActionEvent event) throws InterruptedException {
        elevatorPanel.getListeners().get(0).closedButtonPressed();
        while(elevatorController.moving()){
            System.out.println(elevatorController.getCurrentFloorNum());
            updateState();
            sleep(1000);
        }
        updateState();
        ((ElevatorController) (elevatorPanel.getListeners().get(0))).print();
        setNotice();
        setColorBack();
    }

    @FXML
    public void oneButtonAction(ActionEvent event) {
        oneButton.setStyle("-fx-border-color:red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(1);
    }

    @FXML
    public void twoButtonAction(ActionEvent event) {
        twoButton.setStyle("-fx-border-color:red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(2);
    }

    @FXML
    public void threeButtonAction(ActionEvent event) {
        threeButton.setStyle("-fx-border-color:red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(3);
    }

    @FXML
    public void fourButtonAction(ActionEvent event) {
        fourButton.setStyle("-fx-border-color:red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(4);
    }

    @FXML
    public void fiveButtonAction(ActionEvent event) {
        fiveButton.setStyle("-fx-border-color:red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(5);
    }

    @FXML
    public void sixButtonAction(ActionEvent event) {
        sixButton.setStyle("-fx-border-color:red");
        elevatorPanel.getListeners().get(0).floorButtonPressed(6);
    }

    public void setNotice() {
        notice.setText(((ElevatorController) (elevatorPanel.getListeners().get(0))).getNotice());
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
        int floorNum = ((ElevatorController) (elevatorPanel.getListeners().get(0))).getCurrentFloorNum();
        String doorState = ((ElevatorController) (elevatorPanel.getListeners().get(0))).getDoorState();
        switch (floorNum) {
            case 1:
                oneFloor.setText("*****");
                twoFloor.setText("");
                threeFloor.setText("");
                fourFloor.setText("");
                fiveFloor.setText("");
                sixFloor.setText("");
                oneDoor.setText(doorState);
                twoDoor.setText("");
                threeDoor.setText("");
                fourDoor.setText("");
                fiveDoor.setText("");
                sixDoor.setText("");
                break;
            case 2:
                oneFloor.setText("");
                twoFloor.setText("*****");
                threeFloor.setText("");
                fourFloor.setText("");
                fiveFloor.setText("");
                sixFloor.setText("");
                oneDoor.setText("");
                twoDoor.setText(doorState);
                threeDoor.setText("");
                fourDoor.setText("");
                fiveDoor.setText("");
                sixDoor.setText("");
                break;
            case 3:
                oneFloor.setText("");
                twoFloor.setText("");
                threeFloor.setText("*****");
                fourFloor.setText("");
                fiveFloor.setText("");
                sixFloor.setText("");
                oneDoor.setText("");
                twoDoor.setText("");
                threeDoor.setText(doorState);
                fourDoor.setText("");
                fiveDoor.setText("");
                sixDoor.setText("");
                break;
            case 4:
                oneFloor.setText("");
                twoFloor.setText("");
                threeFloor.setText("");
                fourFloor.setText("*****");
                fiveFloor.setText("");
                sixFloor.setText("");
                oneDoor.setText("");
                twoDoor.setText("");
                threeDoor.setText("");
                fourDoor.setText(doorState);
                fiveDoor.setText("");
                sixDoor.setText("");
                break;
            case 5:
                oneFloor.setText("");
                twoFloor.setText("");
                threeFloor.setText("");
                fourFloor.setText("");
                fiveFloor.setText("*****");
                sixFloor.setText("");
                oneDoor.setText("");
                twoDoor.setText("");
                threeDoor.setText("");
                fourDoor.setText("");
                fiveDoor.setText(doorState);
                sixDoor.setText("");
                break;
            case 6:
                oneFloor.setText("");
                twoFloor.setText("");
                threeFloor.setText("");
                fourFloor.setText("");
                fiveFloor.setText("");
                sixFloor.setText("*****");
                oneDoor.setText("");
                twoDoor.setText("");
                threeDoor.setText("");
                fourDoor.setText("");
                fiveDoor.setText("");
                sixDoor.setText(doorState);
                break;
        }
    }
}
