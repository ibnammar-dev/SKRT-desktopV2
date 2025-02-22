package com.ibn.dev.skrtdesktopv2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink createAccountLink;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        // Simple validation
        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        // Simulate login logic
        if (email.equals("user@example.com") && password.equals("password123")) {
            showAlert("Success", "Login successful!");
        } else {
            showAlert("Error", "Invalid email or password.");
        }
    }

    @FXML
    private void handleCreateAccount() {
        try {
            // Load the register view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register-view.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) createAccountLink.getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SKRT Desktop - Register");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load register view.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
} 