package com.neu.fxController;

import com.neu.listener.ElevatorController;
import com.neu.sensor.ElevatorPanel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class FxController {
    @FXML
    private Button blockButton;
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

    private ElevatorPanel elevatorPanel = new ElevatorPanel();
    private ElevatorController elevatorController = ((ElevatorController) (elevatorPanel.getListeners().get(0)));

    @FXML
    public void blockButtonAction(ActionEvent event) {
        elevatorController.blockButtonPressed();
    }


    @FXML
    public void openButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentState() == elevatorController.getDoorBlocked()) {
            doBlock();
            return;
        }
        elevatorController.openButtonPressed();
        setNotice();
        updateState();
    }

    @FXML
    public void closeButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentState() == elevatorController.getDoorBlocked()) {
            doBlock();
            return;
        }
        if (elevatorController.getCurrentState() == elevatorController.getStop()) {
            notice.setText("Arrived, Please open door");
            return;
        }
        elevatorController.closedButtonPressed();
        new Thread(() -> {
            while (elevatorController.getCurrentFloorNum() != elevatorController.CalcualateAimFloorNum()
                    && elevatorController.getCurrentState() != elevatorController.getStop()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                disableButton();
                elevatorController.moving();
                Platform.runLater(() -> {
                    updateState();
                    setNotice();
                    setColorBack();
                });
            }
            ableButton();
            Platform.runLater(() -> notice.setText("Arrived"));
        }).start();

    }


    @FXML
    public void oneButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentState() == elevatorController.getDoorBlocked()) {
            doBlock();
            return;
        }
        if (elevatorController.getCurrentState() == elevatorController.getIdle()) {
            notice.setText("please open the door first.");
            return;
        }
        if (elevatorController.getCurrentFloorNum() == 1.0) {
            notice.setText("you are already in floor 1");
            return;
        }

        oneButton.setStyle("-fx-border-color:red");
        notice.setText("Floor one selected");
        elevatorPanel.getListeners().get(0).floorButtonPressed(1);
    }

    @FXML
    public void twoButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentState() == elevatorController.getDoorBlocked()) {
            doBlock();
            return;
        }
        if (elevatorController.getCurrentState() == elevatorController.getIdle()) {
            notice.setText("please open the door first.");
            return;
        }
        if (elevatorController.getCurrentFloorNum() == 2.0) {
            notice.setText("you are already in floor 2");
            return;
        }
        twoButton.setStyle("-fx-border-color:red");
        notice.setText("Floor two selected");
        elevatorController.floorButtonPressed(2);
    }

    @FXML
    public void threeButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentState() == elevatorController.getDoorBlocked()) {
            doBlock();
            return;
        }
        if (elevatorController.getCurrentState() == elevatorController.getIdle()) {
            notice.setText("please open the door first.");
            return;
        }
        if (elevatorController.getCurrentFloorNum() == 3.0) {
            notice.setText("you are already in floor 3");
            return;
        }
        threeButton.setStyle("-fx-border-color:red");
        notice.setText("Floor three selected");
        elevatorController.floorButtonPressed(3);
    }

    @FXML
    public void fourButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentState() == elevatorController.getDoorBlocked()) {
            doBlock();
            return;
        }
        if (elevatorController.getCurrentState() == elevatorController.getIdle()) {
            notice.setText("please open the door first.");
            return;
        }
        if (elevatorController.getCurrentFloorNum() == 4.0) {
            notice.setText("you are already in floor 4");
            return;
        }
        fourButton.setStyle("-fx-border-color:red");
        notice.setText("Floor four selected");
        elevatorController.floorButtonPressed(4);
    }

    @FXML
    public void fiveButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentState() == elevatorController.getDoorBlocked()) {
            doBlock();
            return;
        }
        if (elevatorController.getCurrentState() == elevatorController.getIdle()) {
            notice.setText("please open the door first.");
            return;
        }
        if (elevatorController.getCurrentFloorNum() == 5.0) {
            notice.setText("you are already in floor 5");
            return;
        }
        fiveButton.setStyle("-fx-border-color:red");
        notice.setText("Floor five selected");
        elevatorController.floorButtonPressed(5.0);
    }

    @FXML
    public void sixButtonAction(ActionEvent event) {
        if (elevatorController.getCurrentState() == elevatorController.getDoorBlocked()) {
            doBlock();
            return;
        }
        if (elevatorController.getCurrentState() == elevatorController.getIdle()) {
            notice.setText("please open the door first.");
            return;
        }
        if (elevatorController.getCurrentFloorNum() == 6.0) {
            notice.setText("you are already in floor 6");
            return;
        }
        sixButton.setStyle("-fx-border-color:red");
        notice.setText("Floor six selected");
        elevatorController.floorButtonPressed(6.0);
    }


    public void disableButton() {
        oneButton.setDisable(true);
        twoButton.setDisable(true);
        threeButton.setDisable(true);
        fourButton.setDisable(true);
        fiveButton.setDisable(true);
        sixButton.setDisable(true);
        openButton.setDisable(true);
        closeButton.setDisable(true);
        blockButton.setDisable(true);
    }

    public void ableButton() {
        oneButton.setDisable(false);
        twoButton.setDisable(false);
        threeButton.setDisable(false);
        fourButton.setDisable(false);
        fiveButton.setDisable(false);
        sixButton.setDisable(false);
        openButton.setDisable(false);
        closeButton.setDisable(false);
        blockButton.setDisable(false);

    }

    public void doBlock() {
        new Thread(() -> {
            Platform.runLater(() -> {
                disableButton();
                notice.setText("Blocked, please wait 5s");
            });
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ableButton();
            elevatorController.setCurrentState(elevatorController.getIdle());
        }).start();
        return;
    }

    public void setNotice() {
        notice.setText(elevatorController.getNotice());
    }

    public void setColorBack() {
        double floorNum = elevatorController.getCurrentFloorNum();
        switch (String.valueOf(floorNum)) {
            case "1.0":
                oneButton.setStyle("-fx-border-color:null");
                break;
            case "2.0":
                twoButton.setStyle("-fx-border-color:null");
                break;
            case "3.0":
                threeButton.setStyle("-fx-border-color:null");
                break;
            case "4.0":
                fourButton.setStyle("-fx-border-color:null");
                break;
            case "5.0":
                fiveButton.setStyle("-fx-border-color:null");
                break;
            case "6.0":
                sixButton.setStyle("-fx-border-color:null");
                break;
        }
    }


    public void updateState() {
        double floorNum = elevatorController.getCurrentFloorNum();
        String doorState = elevatorController.getDoorState();
        switch (String.valueOf(floorNum)) {
            case "1.0":
                oneFloor.setText("*****");
                twoFloor.setText("");
                oneDoor.setText(doorState);
                twoDoor.setText("");
                oneGap.setText("");
                break;
            case "1.5":
                oneFloor.setText("");
                oneDoor.setText("");
                oneGap.setText("*****");
                twoFloor.setText("");
                twoDoor.setText("");
                break;
            case "2.0":
                twoFloor.setText("*****");
                oneGap.setText("");
                twoGap.setText("");
                twoDoor.setText(doorState);
                break;
            case "2.5":
                twoFloor.setText("");
                twoDoor.setText("");
                threeFloor.setText("");
                threeDoor.setText("");
                twoGap.setText("*****");
                break;
            case "3.0":
                twoGap.setText("");
                threeGap.setText("");
                threeDoor.setText(doorState);
                threeFloor.setText("*****");
                break;
            case "3.5":
                fourFloor.setText("");
                fourDoor.setText("");
                threeFloor.setText("");
                threeDoor.setText("");
                threeGap.setText("*****");
                break;
            case "4.0":
                fourGap.setText("");
                threeGap.setText("");
                fourDoor.setText(doorState);
                fourFloor.setText("*****");
                break;
            case "4.5":
                fourFloor.setText("");
                fourDoor.setText("");
                fiveFloor.setText("");
                fiveDoor.setText("");
                fourGap.setText("*****");
                break;
            case "5.0":
                fourGap.setText("");
                fiveGap.setText("");
                fiveDoor.setText(doorState);
                fiveFloor.setText("*****");
                break;
            case "5.5":
                sixFloor.setText("");
                sixDoor.setText("");
                fiveFloor.setText("");
                fiveDoor.setText("");
                fiveGap.setText("*****");
                break;
            case "6.0":
                fiveGap.setText("");
                sixDoor.setText(doorState);
                sixFloor.setText("*****");
                break;
        }

    }

}
