package com.example.demo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

import java.io.File;

public class Home {
public PythonJavaIntegration helper = new PythonJavaIntegration();

// ...

    @FXML
    private void chooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            String imagePath = selectedFile.getAbsolutePath();

            Image selectedImage = new Image(selectedFile.toURI().toString());

String result = helper.executecode(imagePath);
            // Display a message box
            showImageSelectedAlert(result);
        }
    }

    private void showImageSelectedAlert(String imagePath) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Image Selected");
        alert.setHeaderText("Image selected successfully");
        alert.setContentText("Selected Image Path: " + imagePath);

        alert.showAndWait();
    }
}
