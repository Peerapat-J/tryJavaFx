package com.example.demo3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Sphere object;
    private double cordXObject;
    private double cordYObject;

    @FXML
    private Slider widthController;

    @FXML
    private Slider hightController;

    @FXML
    private Button mainButton;

    @FXML
    private Button logButton;

    @FXML
    private Button aboutButton;

    @FXML
    public void Up(ActionEvent e){
        cordYObject = object.getLayoutY();
        if((cordYObject - 5) <= 250 && (cordYObject - 5) >= 210){
            object.setLayoutY(cordYObject -= 5);
        }
        System.out.println("X:" + cordXObject + ", Y:" + cordYObject);
    }
    public void Right(ActionEvent e){
        cordXObject = object.getLayoutX();
        if((cordXObject + 5) <= 171 && (cordXObject + 5) >= 141){
            object.setLayoutX(cordXObject += 5);
        }
        System.out.println("X:" + cordXObject + ", Y:" + cordYObject);
    }
    public void Down(ActionEvent e){
        cordYObject = object.getLayoutY();
        if((cordYObject + 5) <= 250 && (cordYObject + 5) >= 210){
            object.setLayoutY(cordYObject += 5);
        }
        System.out.println("X:" + cordXObject + ", Y:" + cordYObject);
    }
    public void Left(ActionEvent e){
        cordXObject = object.getLayoutX();
        if((cordXObject - 5) <= 171 && (cordXObject - 5) >= 141){
            object.setLayoutX(cordXObject -= 5);
        }
        System.out.println("X:" + cordXObject + ", Y:" + cordYObject);
    }

    public void Reset(ActionEvent e){
        object.setRadius(50);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (object != (null)){
            double wDefault = object.getScaleX();
            double hDefault = object.getScaleY();
            widthController.valueProperty().addListener(new ChangeListener<Object>() {
                @Override
                public void changed(ObservableValue<?> observableValue, Object o, Object t1) {
//                widthOfObject = object.getScaleX();
                    System.out.println("objScaleX:" + widthController.getValue() / 500);
                    System.out.println("w-default: " + wDefault);
                    object.setScaleX(wDefault + (widthController.getValue() / 500));
                }
            });
            hightController.valueProperty().addListener(new ChangeListener<Object>() {
                @Override
                public void changed(ObservableValue<? extends Object> observableValue, Object number, Object t1) {
                    System.out.println("objScaleY:" + hightController.getValue() / 500);
                    System.out.println("h-default: " + hDefault);
                    object.setScaleY(hDefault + (hightController.getValue() / 500));
                }
            });
        }
    }

    public void goToMain(ActionEvent e) throws IOException {
        Parent mainFtml = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Stage mainWindow = (Stage) mainButton.getScene().getWindow();
        mainWindow.setScene(new Scene(mainFtml));
        System.out.println("main btn clicked!");
    }
    public void goToLog(ActionEvent e) throws IOException {
        Parent LogFtml = FXMLLoader.load(getClass().getResource("Log.fxml"));
        Stage mainWindow = (Stage) logButton.getScene().getWindow();
        mainWindow.setScene(new Scene(LogFtml));
        System.out.println("log btn clicked!");

    }
    public void goToAbout(ActionEvent e) throws IOException {
        Parent AboutFtml = FXMLLoader.load(getClass().getResource("About.fxml"));
        Stage mainWindow = (Stage) aboutButton.getScene().getWindow();
        mainWindow.setScene(new Scene(AboutFtml));
        System.out.println("abt btn clicked!");
    }
}