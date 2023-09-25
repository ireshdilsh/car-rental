package controller.save;

import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.CarDaoImpl;
import dto.CarCategoryDto;
import dto.CarDto;
import entity.CarEntity;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import service.ServiceFactory;
import service.custom.CarCateoryService;
import service.custom.CarService;

public class CarViewController {
    public JFXTextField idText;
    public JFXTextField priceText;
    public JFXTextField yearText;
    public JFXTextField noText;
    public JFXTextField modelText;
    public JFXTextField brandText;
    public JFXTextField categoryText;


    CarCateoryService <CarCategoryDto>carCateoryService= (CarCateoryService<CarCategoryDto>) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);
    CarService carService= (CarService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CAR);
    public void saveCar(ActionEvent event) {

        Alert  alert=new Alert(Alert.AlertType.CONFIRMATION,"Do you want to add new Car");
        if (alert.showAndWait().get()== ButtonType.OK) {
                if (idText.getText().isEmpty()&&priceText.getText().isEmpty()&&yearText.getText().isEmpty()&&noText.getText().isEmpty()&&
                modelText.getText().isEmpty()&&brandText.getText().isEmpty()&&categoryText.getText().isEmpty()){
                    new Alert(Alert.AlertType.WARNING,"Please Fill all fields").show();
                }else {
                    CarDto carDto = new CarDto();
                    carDto.setCarid(idText.getText());
                    carDto.setBrand(brandText.getText());
                    carDto.setModel(modelText.getText());
                    carDto.setYear(yearText.getText());
                    carDto.setVehino(Integer.valueOf(noText.getText()));
                    carDto.setPriceperday(Double.valueOf(priceText.getText()));

                    CarCategoryDto carCategoryDto = carCateoryService.search(categoryText.getText());
                    carDto.setCarCategoryDto(carCategoryDto);

                    carService.saveCar(carDto);
                    Clear();
                }
        }
    }

    public void Clear(){
        noText.setText("");
        idText.setText("");brandText.setText("");modelText.setText("");yearText.setText("");priceText.setText("");categoryText.setText("");
    }

    public void updateCar(ActionEvent event) {

        Alert  alert=new Alert(Alert.AlertType.CONFIRMATION,"Do you want to update  Car");
        if (alert.showAndWait().get()== ButtonType.OK) {
            if (idText.getText().isEmpty()&&priceText.getText().isEmpty()&&yearText.getText().isEmpty()&&noText.getText().isEmpty()&&
                    modelText.getText().isEmpty()&&brandText.getText().isEmpty()&&categoryText.getText().isEmpty()){
                new Alert(Alert.AlertType.WARNING,"Please Fill all fields").show();
            }else {

                CarDto carDto = new CarDto();
                carDto.setCarid(idText.getText());
                carDto.setBrand(brandText.getText());
                carDto.setModel(modelText.getText());
                carDto.setYear(yearText.getText());
                carDto.setVehino(Integer.valueOf(noText.getText()));
                carDto.setPriceperday(Double.valueOf(priceText.getText()));

                CarCategoryDto carCategoryDto = carCateoryService.search(categoryText.getText());
                carDto.setCarCategoryDto(carCategoryDto);

                carService.updateCar(carDto);
            }
        }
    }
    public void showCars(ActionEvent event) {

        String carId = idText.getText();
        CarDaoImpl carDao = new CarDaoImpl();
        CarEntity carEntity = carDao.search(carId);
        if (carEntity!=null){
            brandText.setText(carEntity.getBrand());
            modelText.setText(carEntity.getModel());
            yearText.setText(carEntity.getYear());
            noText.setText(String.valueOf(carEntity.getVehino()));
            priceText.setText(String.valueOf(carEntity.getPriceperday()));
            categoryText.setText(carEntity.getCarCategoryEntity().getCategoryid());
        } else {
            new Alert(Alert.AlertType.ERROR, "CarCategory Not Found!").show();
        }
    }

    public void CarDelete(ActionEvent event) {
        String carId = idText.getText();
        CarDto dto = new CarDto();
        dto.setCarid(carId);
        carService.deleteCar(dto);
    }
}
