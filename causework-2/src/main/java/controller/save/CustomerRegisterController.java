package controller.save;


import com.jfoenix.controls.JFXTextField;
import dto.CustomerDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.CustomerService;

import java.io.IOException;

public class CustomerRegisterController {

    CustomerService customerService= (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public JFXTextField idText;
    public JFXTextField nicText;
    public JFXTextField nameText;
    public JFXTextField adressText;
    public JFXTextField mobilenoText;


    public void saveCustomer(ActionEvent event) {

       Alert alert= new Alert(Alert.AlertType.CONFIRMATION,"Do you want add new Customer ?");

        if (alert.showAndWait().get()==ButtonType.OK){

            if (idText.getText().isEmpty()&&nicText.getText().isEmpty()&&nameText.getText().isEmpty()&&adressText.getText().isEmpty()&&mobilenoText.getText().isEmpty()){

                new Alert(Alert.AlertType.WARNING,"Please fill all fields").show();

            }else {

                String id= idText.getText();
                String nic= nicText.getText();
                String name= nameText.getText();
                String address= adressText.getText();
                Integer mobule= Integer.valueOf(mobilenoText.getText());

                CustomerDto customerDto=new CustomerDto();

                customerDto.setCustid(id);
                customerDto.setNic(nic);
                customerDto.setName(name);
                customerDto.setAddress(address);
                customerDto.setMobileno(mobule);

                customerService.saveCustomer(customerDto);
            }
        }
    }

    public void updateCustomer(ActionEvent event) {

        Alert alert= new Alert(Alert.AlertType.CONFIRMATION,"Do you want update  Customer ?");

        if (alert.showAndWait().get()==ButtonType.OK){

            if (idText.getText().isEmpty()&&nicText.getText().isEmpty()&&nameText.getText().isEmpty()&&adressText.getText().isEmpty()&&mobilenoText.getText().isEmpty()){

                new Alert(Alert.AlertType.WARNING,"Please fill all fields").show();

            }else {

                String id= idText.getText();
                String nic= nicText.getText();
                String name= nameText.getText();
                String address= adressText.getText();
                Integer mobule= Integer.parseInt(mobilenoText.getText());

                CustomerDto customerDto=new CustomerDto();

                customerDto.setCustid(id);
                customerDto.setNic(nic);
                customerDto.setName(name);
                customerDto.setAddress(address);
                customerDto.setMobileno(mobule);

                customerService.updateCustomer(customerDto);
            }
        }
    }

    public void deleteCustomer(ActionEvent event) {

        Alert alert= new Alert(Alert.AlertType.CONFIRMATION,"Do you want Delete  Customer ?");
    if (alert.showAndWait().get()==ButtonType.OK){
        String customerId =idText.getText();
        CustomerDto dto = new CustomerDto();
        dto.setCustid(customerId);
        customerService.deleteCustomer(dto);
    }else {}
    }

    public void showCustomers(ActionEvent event) {
        String id= idText.getText();
        CustomerDto customerDto=customerService.search(id);

        if (customerDto!=null){
            nicText.setText(customerDto.getNic());
            nameText.setText(customerDto.getName());
            adressText.setText(customerDto.getAddress());
            mobilenoText.setText(String.valueOf(customerDto.getMobileno()));
        }else {
            new Alert(Alert.AlertType.WARNING,"Customer not found").show();
        }
    }
}