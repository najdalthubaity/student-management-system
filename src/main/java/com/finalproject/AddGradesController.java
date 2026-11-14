/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AddGradesController {
   
    
   @FXML
private ComboBox<String> studentIdField;

    @FXML
    private TextField gradeField;

    @FXML
    private Label resultLabel;
    
    @FXML
public void initialize() {
    loadStudentIds();
}

    private void loadStudentIds() {

    try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {

        String line;

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            if (data.length >= 2) {

                String id = data[1].trim();

                studentIdField.getItems().add(id);
            }
        }

    } catch (IOException e) {

        resultLabel.setText("Error loading students");
    }
}


    @FXML
    private void saveGrade() {

        try {

String id = studentIdField.getValue();
            double grade =
                    Double.parseDouble(
                            gradeField.getText());

            double average = grade;

            FileWriter writer =
                    new FileWriter(
                            "grades.txt",
                            true);

            writer.write(
                    id + ","
                            + grade + ","
                            + average
                            + "\n");

            writer.close();

            resultLabel.setText(
                    "Saved Successfully");

           studentIdField.setValue(null);
            gradeField.clear();

        } catch (Exception e) {

            resultLabel.setText(
                    "Enter valid data");

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



