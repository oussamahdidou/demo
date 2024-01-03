package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class HelloController {

    @FXML
    private StackPane rootPane;
    @FXML
    public void initialize() throws IOException {
        // Initialization logic for Screen1Controller
        this.switchToScreen1();
    }
    @FXML
    public void switchToScreen1() throws IOException {
        loadScreen("signin.fxml");
    }

    @FXML
    public void switchToScreenhome() throws IOException {
        loadScreen("Home.fxml");
    }

    @FXML
    public void switchToScreen3() throws IOException {
        loadScreen("Screen3.fxml");
    }

    public void loadScreen(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Node screen = loader.load();
        rootPane.getChildren().setAll(screen);
    }

}
