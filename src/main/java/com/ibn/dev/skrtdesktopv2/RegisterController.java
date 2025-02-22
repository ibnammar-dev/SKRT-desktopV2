package com.ibn.dev.skrtdesktopv2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private Button registerButton;

    @FXML
    private Hyperlink loginLink;

    @FXML
    private void handleRegister() {
        String email = emailField.getText();
        String password = passwordField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        // Simple validation
        if (email.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        // Simulate registration logic
        showAlert("Success", "Registration successful!");
    }

    @FXML
    private void handleLoginLink() {
        try {
            // Load the login view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) loginLink.getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SKRT Desktop - Login");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load login view.");
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