package controller.save;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.UserService;

import java.io.IOException;

public class UserController {
    public AnchorPane pane;
    public JFXTextField nameTeaxt;
    public JFXTextField addressText;
    public JFXTextField emailText;
    public JFXTextField usernameText;
    public JFXPasswordField passwordText;
    public JFXTextField idText;
    @FXML
    private JFXRadioButton agreeradioButton;

    UserService userService= (UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);
    public void gotoLogin(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/view/Login-View.fxml"));
        Stage stage= (Stage) this.pane.getScene().getWindow();
        stage.setTitle("Log in");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void saveUserDetails(ActionEvent event) {

       Alert alert= new Alert(Alert.AlertType.CONFIRMATION,"Do you want to add New User ?");

        if (alert.showAndWait().get()==ButtonType.OK) {
            if (idText.getText().isEmpty() && nameTeaxt.getText().isEmpty() && emailText.getText().isEmpty() && usernameText.getText().isEmpty() && passwordText.getText().isEmpty() && addressText.getText().isEmpty()){
                new Alert(Alert.AlertType.ERROR,"Please fill the fields").show();
            }else {

            String id = idText.getText();
            String name = nameTeaxt.getText();
            String email = emailText.getText();
            String username = usernameText.getText();
            String password = passwordText.getText();
            String address = addressText.getText();

            if (agreeradioButton.isSelected()) {

                UserDto userDto = new UserDto();

                userDto.setId(id);
                userDto.setName(name);
                userDto.setEmail(email);
                userDto.setPassword(password);
                userDto.setUsername(username);
                userDto.setAddress(address);

                userService.saveUser(userDto);

            }else {
                new Alert(Alert.AlertType.ERROR,"Please Agree our terms and Conditions").show();
            }
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"User save error").show();
        }
    }

    public void updateUser(ActionEvent event) {
    }

    public void deleteUser(ActionEvent event) {
    }

    public void getAllUser(ActionEvent event) {
    }
}
