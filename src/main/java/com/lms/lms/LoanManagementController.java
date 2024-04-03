package com.lms.lms;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoanManagementController {

    private Stage stage;

    private Scene scene;

    private Parent root;
    private LoanDAO loanDAO;


    @FXML
    public void switchToMainDashboard(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-dashboard.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        System.out.println("Save Button Clicked");
    }

    public void setPartDAO(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }
}
