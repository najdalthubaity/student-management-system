package com.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReportController {

    @FXML
    private Label totalStudentsLabel;

    @FXML
    private Label fileStatusLabel;

    @FXML
    private Label reportLabel;

    @FXML
    private void generateReport() {

        File file = new File("grades.txt");
        File studentsFile = new File("students.txt");

        if (!file.exists() || !studentsFile.exists()) {
            fileStatusLabel.setText("File Status: Missing files");
            return;
        }

        int studentCount = 0;
        int gradeCount = 0;

        double total = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        try {

           
            BufferedReader br1 = new BufferedReader(new FileReader(studentsFile));
            while (br1.readLine() != null) {
                studentCount++;
            }
            br1.close();

         
            BufferedReader br2 = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br2.readLine()) != null) {

                String[] data = line.split(",");

                double grade = Double.parseDouble(data[1].trim());

                total += grade;
                gradeCount++;

                if (grade > max) max = grade;
                if (grade < min) min = grade;
            }

            br2.close();

            double avg = (gradeCount > 0) ? total / gradeCount : 0;

            totalStudentsLabel.setText("Total Students: " + studentCount);

            fileStatusLabel.setText("File Status: Loaded Successfully");

            reportLabel.setText(
                    "Total Grades: " + gradeCount +
                    "\nAverage Grade: " + avg +
                    "\nHighest Grade: " + max +
                    "\nLowest Grade: " + min
            );

        } catch (IOException e) {
            fileStatusLabel.setText("Error reading files");
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
   