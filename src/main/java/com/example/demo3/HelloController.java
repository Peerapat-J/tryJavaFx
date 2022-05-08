package com.example.demo3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Slider;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

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
    private Hyperlink mailToMe;

    @FXML
    private Hyperlink agreement;


    @FXML
    public void Up(ActionEvent event){
        cordYObject = object.getLayoutY();
        if((cordYObject - 5) <= 250 && (cordYObject - 5) >= 210){
            object.setLayoutY(cordYObject -= 5);
        }
    }
    public void Right(ActionEvent event){
        cordXObject = object.getLayoutX();
        if((cordXObject + 5) <= 171 && (cordXObject + 5) >= 141){
            object.setLayoutX(cordXObject += 5);
        }
    }
    public void Down(ActionEvent event){
        cordYObject = object.getLayoutY();
        if((cordYObject + 5) <= 250 && (cordYObject + 5) >= 210){
            object.setLayoutY(cordYObject += 5);
        }
    }
    public void Left(ActionEvent event){
        cordXObject = object.getLayoutX();
        if((cordXObject - 5) <= 171 && (cordXObject - 5) >= 141){
            object.setLayoutX(cordXObject -= 5);
        }
    }

    public void Reset(ActionEvent event){
        object.setRadius(50);
    }
    final double SCALE = 500;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (object != (null)){
            double wDefault = object.getScaleX();
            double hDefault = object.getScaleY();
            widthController.valueProperty().addListener(new ChangeListener<Object>() {
                @Override
                public void changed(ObservableValue<?> observableValue, Object o, Object t1) {
                    object.setScaleX(wDefault + (widthController.getValue() / SCALE));
                }
            });
            hightController.valueProperty().addListener(new ChangeListener<Object>() {
                @Override
                public void changed(ObservableValue<? extends Object> observableValue, Object number, Object t1) {
                    object.setScaleY(hDefault + (hightController.getValue() / SCALE));
                }
            });
        }
    }

    public void goToMain(ActionEvent event) throws IOException {
        Parent mainFtml = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Stage mainWindow = (Stage) mainButton.getScene().getWindow();
        mainWindow.setScene(new Scene(mainFtml));
    }
    public void goToLog(ActionEvent event) throws IOException {
        Parent LogFtml = FXMLLoader.load(getClass().getResource("Log.fxml"));
        Stage mainWindow = (Stage) logButton.getScene().getWindow();
        mainWindow.setScene(new Scene(LogFtml));

    }
    public void goToAbout(ActionEvent event) throws IOException {
        Parent AboutFtml = FXMLLoader.load(getClass().getResource("About.fxml"));
        Stage mainWindow = (Stage) aboutButton.getScene().getWindow();
        mainWindow.setScene(new Scene(AboutFtml));
    }

    public void mailToMe() throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        System.out.println("Mail get clicked");
        if (Desktop.isDesktopSupported() && (Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
            try {
                String uri = new URI("mailto",
                        "Peerapat.Jardrit@gmail.com", null).toString();
                desktop.mail(new URI(uri));
            } catch (IOException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Can't create email");
                alert.setContentText("something wrong /w your e-mail?");
                alert.showAndWait();
            } catch (IllegalArgumentException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Can't create email");
                alert.setContentText("Working on it");
                alert.showAndWait();
            }
        }
    }

    public void freewareAgreement(ActionEvent event) throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI("https://www.freescreenrecording.com/legal/freeware_license_agreement.html"));
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Compatibility Error");
            alert.setContentText("Desktop class called by this software is not supported on your current platform.");
            alert.showAndWait();
        }
    }
}