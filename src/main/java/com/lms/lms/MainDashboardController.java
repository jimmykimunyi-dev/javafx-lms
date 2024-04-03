package com.lms.lms;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashboardController {

    @FXML
    private Button bookMgt;

    @FXML
    private Button exit;

    @FXML
    private Button loanMgt;

    @FXML
    private Button userMgt;

    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    public void switchToBookManagement(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("book-management.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            // Get the BookManagementController and initialize the BookDAO
             BookManagementController addBookManagementController = loader.getController();
             addBookManagementController.setBookDAO(new BookDAO());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void switchToUserManagement(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("user-management.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            // Get the AddUserManagementController and initialize the UserDAO
             UserManagementController addUserManagementController = loader.getController();
             addUserManagementController.setPartDAO(new UserDAO());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void switchToLoanManagement(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loan-management.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            // Get the LoanManagementController and initialize the LoanDAO
            LoanManagementController addLoanManagementController = loader.getController();
            addLoanManagementController.setPartDAO(new LoanDAO());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void exit(){
        Platform.exit();
    }

}
