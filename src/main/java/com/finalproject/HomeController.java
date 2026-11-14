package com.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;

public class HomeController {

    private void switchScene(ActionEvent event, String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void openAddStudent(ActionEvent event) throws IOException {
        switchScene(event, "/fxml/AddStudent.fxml");
    }

    @FXML
    public void openViewStudents(ActionEvent event) throws IOException {
       switchScene(event, "/fxml/ViewStudents.fxml");
    }

    @FXML
    public void openGrades(ActionEvent event) throws IOException {
        switchScene(event, "/fxml/AddGrades.fxml");
    }

    @FXML
    public void openReports(ActionEvent event) throws IOException {
       switchScene(event, "/fxml/Report.fxml");
    }
}
