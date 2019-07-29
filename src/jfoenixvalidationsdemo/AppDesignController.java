/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfoenixvalidationsdemo;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.ValidationFacade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 *
 * @author Spark
 */
public class AppDesignController implements Initializable {

    @FXML
    private JFXTextField oldPassword;

    @FXML
    private JFXTextField newPassword;

    @FXML
    private JFXTextField confirmPassword;

    RequiredFieldValidator requiredFieldValidator1;
    RequiredFieldValidator requiredFieldValidator2;
    RequiredFieldValidator requiredFieldValidator3;

    private void setupValidation() {
        requiredFieldValidator1 = new RequiredFieldValidator();
        requiredFieldValidator1.setIcon(new ImageView(getClass().getResource("warning.png").toString()));
        requiredFieldValidator1.setMessage("Empty Field");
        
        oldPassword.getValidators().add(requiredFieldValidator1);
        oldPassword.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(!newValue){
                oldPassword.validate();
            }
        });
        oldPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.isEmpty()){
                oldPassword.resetValidation();
            }else if(newValue.isEmpty()){
                oldPassword.validate();
            }
        });
        requiredFieldValidator2 = new RequiredFieldValidator();
        requiredFieldValidator2.setIcon(new ImageView(getClass().getResource("warning.png").toString()));
        requiredFieldValidator2.setMessage("Empty Field");
        newPassword.getValidators().add(requiredFieldValidator2);
        newPassword.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(!newValue){
                newPassword.validate();
            }
        });
        newPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.isEmpty()){
                newPassword.resetValidation();
            }else if(newValue.isEmpty()){
                newPassword.validate();
            }
        });

        requiredFieldValidator3 = new RequiredFieldValidator();
        requiredFieldValidator3.setIcon(new ImageView(getClass().getResource("warning.png").toString()));
        requiredFieldValidator3.setMessage("Empty Field");
        confirmPassword.getValidators().add(requiredFieldValidator3);
        confirmPassword.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(!newValue){
                confirmPassword.validate();
            }
        });
        confirmPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.isEmpty()){
                confirmPassword.resetValidation();
            }else if(newValue.isEmpty()){
                confirmPassword.validate();
            }
        });

    }

    @FXML
    void Submit(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupValidation();
    }

}
