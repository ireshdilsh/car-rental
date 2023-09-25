package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;

public class LoginController {
    public AnchorPane pane;
    public JFXTextField usernameText;
    public JFXPasswordField passwordText;
    public BorderPane pane1;

    public void gotoSignup(ActionEvent event) throws IOException{

        Parent root=FXMLLoader.load(getClass().getResource("/view/User-View.fxml"));
        Stage stage= (Stage) this.pane.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("User Register");
        stage.show();
    }

    public void gotoDashboard(ActionEvent event) throws IOException {
        if (usernameText.getText().isEmpty() && passwordText.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please Enter Your Username and Password !").show();
        } else if (usernameText.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Please Enter Your Username !").show();
        } else if (passwordText.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"please Enter Your Password !").show();
        }else {
            Parent root= FXMLLoader.load(getClass().getResource("/view/Dashboard-View.fxml"));
            Stage stage= (Stage) this.pane.getScene().getWindow();
            stage.setTitle("Dashboard");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    public void gotoUserView(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/view/User-View.fxml"));
        pane1.setCenter(root);
    }

    public void gotoCustomerView(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/view/Customer-Register-View.fxml"));
        pane1.setCenter(root);
    }

    public void gotoCarView(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/view/Car-View.fxml"));
        pane1.setCenter(root);
    }

    public void gotoCarCategoryView(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/view/Car-Category-View.fxml"));
        pane1.setCenter(root);
    }

    public void gotoLogout(ActionEvent event) throws IOException{

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Do you want log out your Account ?");

        if (alert.showAndWait().get()== ButtonType.OK) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login-View.fxml"));
            Stage stage = (Stage) this.pane1.getScene().getWindow();
            stage.setTitle("Log in");
            stage.setScene(new Scene(root));
            stage.show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Log out Fail").show();
        }
    }

    public void gotoRentView(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/view/Rent-View.fxml"));
        pane1.setCenter(root);
    }
}
