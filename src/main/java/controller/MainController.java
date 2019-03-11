package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainController {

    @FXML
    private Button button;

    @FXML
    private Pane pane;

    @FXML
    public void initialize(){
    }

    @FXML
    public void clicked(ActionEvent event){
        button.setLayoutX(Math.random()*(pane.getWidth()-button.getWidth()));
        button.setLayoutY(Math.random()*(pane.getHeight()-button.getWidth()));
        button.setRotate(Math.random()*360);
        System.out.println(button.getLayoutX());
        System.out.println(button.getLayoutY());
    }
}
