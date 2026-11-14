package com.finalproject;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewStudentsController {

    @FXML
    private ComboBox<String> idStudent;

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

                idStudent.getItems().add(id);
            }
        }

    } catch (IOException e) {

        resultLabel.setText("Error loading students");
    }
}
    @FXML
    private void showStudent() {

        String id = idStudent.getValue();

        if (id == null) {
            resultLabel.setText("Select Student ID");
            return;
        }

        String studentInfo = "";
        String gradesInfo = "No grades found";
        double total = 0;
        int count = 0;

        try {

          
         BufferedReader br1 = new BufferedReader(new FileReader("students.txt"));

String line;

while ((line = br1.readLine()) != null) {

    String[] data = line.split(",");

    if (data.length >= 2 && data[1].trim().equals(id)) {

        studentInfo = line;

        break;
    }
}

br1.close();
            
            BufferedReader br2 = new BufferedReader(new FileReader("grades.txt"));

            String gradeLine;

            while ((gradeLine = br2.readLine()) != null) {

                String[] data = gradeLine.split(",");

                if (data[0].trim().equals(id)) {

                    double grade = Double.parseDouble(data[1]);

                    total += grade;
                    count++;
                }
            }

            br2.close();

            if (count > 0) {
                double avg = total / count;
                gradesInfo = "Average Grade: " + avg;
            }

            resultLabel.setText(studentInfo + "\n" + gradesInfo);

        } catch (IOException e) {
            resultLabel.setText("Error reading files");
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