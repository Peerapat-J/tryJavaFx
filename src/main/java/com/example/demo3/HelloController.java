package com.example.demo3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.shape.Sphere;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Sphere object;
    private double cordXObject;
    private double cordYObject;

    @FXML
    private Slider widthController;
//    private double wDefault = object.getScaleX();
//    private double hDefault = object.getScaleY();

    @FXML
    private Slider hightController;

    @FXML
    public void Up(ActionEvent e){
        cordYObject = object.getLayoutY();
        if((cordYObject - 5) <= 250 && (cordYObject - 5) >= 210){
            object.setLayoutY(cordYObject -= 5);
        }
        System.out.println("X:" + cordXObject + ", Y:" + cordYObject);
    }
    public void Right(ActionEvent e){
        // max y = 210, x = 171
        // min y = 250, x = 141
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

    public void WidthSize(ActionEvent e){
//        widthOfObject = object.getScaleX();
//        object.setScaleX(widthOfObject += (widthController.getValue() / 10_000) );
//        System.out.println("widthOfObject:" + widthOfObject);
//        System.out.println("widthController:" + widthController.getValue());
    }

    public void Reset(ActionEvent e){
        object.setRadius(50);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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