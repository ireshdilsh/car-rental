package controller.save;

import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.CarCategoryDaoImpl;
import dto.CarCategoryDto;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import service.ServiceFactory;
import service.custom.CarCateoryService;

public class CarcategoryViewController {

    CarCateoryService carCateoryService= (CarCateoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);


    public JFXTextField idText;
    public JFXTextField nameText;

    public void saveCategory(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Do youn want to add new Category");
        if (alert.showAndWait().get()== ButtonType.OK){

        if (idText.getText().isEmpty()&&nameText.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Please Fill fields").show();
        }else{

        String id = idText.getText();
        String name = nameText.getText();

        CarCategoryDto carCategoryDto = new CarCategoryDto();
        carCategoryDto.setCategoryid(id);
        carCategoryDto.setName(name);
        carCateoryService.saveCategory(carCategoryDto);
        }
    }else {

        }
    }

    public void updateCategory(ActionEvent event) {

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Do youn want to update  Category");
        if (alert.showAndWait().get()== ButtonType.OK) {

            if (idText.getText().isEmpty() && nameText.getText().isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Please Fill fields").show();
            } else {

                String id = idText.getText();
                String name = nameText.getText();

                CarCategoryDto carCategoryDto = new CarCategoryDto();
                carCategoryDto.setCategoryid(id);
                carCategoryDto.setName(name);

                carCateoryService.updateCarCategory(carCategoryDto);
                Clear();
            }
        }else {

        }
    }
    public void Clear(){
        idText.setText("");nameText.setText("");
    }
    public void deleteCategory(ActionEvent event) {

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Do youn want to delete  Category");
        if (alert.showAndWait().get()== ButtonType.OK) {

            if (idText.getText().isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Please enter category id").show();
            } else {
                String carcategoryId = idText.getText();
                CarCategoryDto dto = new CarCategoryDto();
                dto.setCategoryid(carcategoryId);
                carCateoryService.deleteCarCategory(dto);
            }
        }else {
        }
    }

    public void showCategory(ActionEvent event) {
        String cacategoryId = idText.getText();
        CarCategoryDaoImpl carCategoryDao = new CarCategoryDaoImpl();
        CarCategoryDto dto = carCateoryService.search(cacategoryId);
        if (dto!=null){
            nameText.setText(dto.getName());
        } else {
            new Alert(Alert.AlertType.ERROR, "CarCategory Not Found!").show();
        }
    }
}
