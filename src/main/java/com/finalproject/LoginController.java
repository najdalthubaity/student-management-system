package com.finalproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {

        String username = usernameField.getText();

        String password = passwordField.getText();

        if(username.equals("demo") && password.equals("demo123")){
            
            messageLabel.setText("");
            
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
            
            Stage stage =(Stage) loginButton.getScene().getWindow();
            
            stage.setScene(new Scene(root));
            
            stage.show();
          
       
        }else{
       

          messageLabel.setText("Wrong Username or Password");    }
}
} 