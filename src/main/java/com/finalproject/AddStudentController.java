
package com.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddStudentController {

    
    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField majorField;

    @FXML
    private Label messageLabel;


    @FXML
    private void saveStudent() {

        String name = nameField.getText();
        String id = idField.getText();
        String major = majorField.getText();

        try {
            FileWriter writer = new FileWriter("students.txt", true);

            writer.write(
        name + "," +
        id + "," +
        major + "\n"
);

            writer.close();

            messageLabel.setText("Student Saved Successfully");

            nameField.clear();
            idField.clear();
            majorField.clear();

        } catch (IOException e) {

            messageLabel.setText("Error Saving Student");
        }
    }
    
    @FXML
private void back(ActionEvent event) throws IOException {

    Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    stage.setScene(new Scene(root));
    stage.show();
}
    
    
}
