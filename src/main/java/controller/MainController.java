package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.Timer;
import java.util.TimerTask;

public class MainController {

    private double desiredButtonLayoutX;
    private double desiredButtonLayoutY;
    private double buttonTravelSpeed;

    @FXML
    private Button button;

    @FXML
    private Pane pane;

    @FXML
    public void initialize(){
        desiredButtonLayoutX = button.getLayoutX();
        desiredButtonLayoutY = button.getLayoutY();
        buttonTravelSpeed = 5.0;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    double layoutX = desiredButtonLayoutX - button.getLayoutX();
                    double layoutY = desiredButtonLayoutY - button.getLayoutY();
                    double vectorMagnitude = Math.sqrt(layoutX * layoutX +
                            layoutY * layoutY);
                    if(vectorMagnitude > buttonTravelSpeed){
                        button.setLayoutX(button.getLayoutX() +
                                buttonTravelSpeed * layoutX / vectorMagnitude);
                        button.setLayoutY(button.getLayoutY() +
                                buttonTravelSpeed * layoutY / vectorMagnitude);
                    } else {
                        button.setLayoutX(desiredButtonLayoutX);
                        button.setLayoutY(desiredButtonLayoutY);
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task,0,20);
    }

    @FXML
    public void clicked(ActionEvent event){
        desiredButtonLayoutX = Math.random() * (pane.getWidth() - button.getWidth());
        desiredButtonLayoutY = Math.random() * (pane.getHeight() - button.getHeight());
    }
}
