package controller.save;

import com.jfoenix.controls.JFXTextField;
import dto.CarDto;
import dto.CustomerDto;
import dto.RentDto;
import entity.CarEntity;
import javafx.event.ActionEvent;
import service.ServiceFactory;
import service.custom.CarService;
import service.custom.CustomerService;
import service.custom.RentService;

import java.time.Instant;
import java.util.Date;

public class RentViewController {
    public JFXTextField rentidText;
    public JFXTextField carIdText;
    public JFXTextField advancedText;
    public JFXTextField depositText;
    public JFXTextField balancedText;
    public JFXTextField returnText;
    public JFXTextField todateTrext;
    public JFXTextField peradyRentText;
    public JFXTextField custidText;
    public JFXTextField tottal;

    CarService carService= (CarService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CAR);
    CustomerService customerService= (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    RentService rentService= (RentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENT);
    public void saveRent(ActionEvent event) {

        try {

            RentDto rentDto = new RentDto();

            rentDto.setRentid(rentidText.getText());
            rentDto.setFrom_date(new Date());
            rentDto.setTo_date(new Date());
            rentDto.setPerdayrent(Double.valueOf(peradyRentText.getText()));
            rentDto.setIsreturn(Boolean.parseBoolean(returnText.getText()));
            rentDto.setTotal(Double.valueOf(tottal.getText()));
            rentDto.setBalance(Double.valueOf(balancedText.getText()));
            rentDto.setAdvancespay(Double.valueOf(advancedText.getText()));

            CarDto carDto = carService.searchCar(carIdText.getText());
            rentDto.setCarDto(carDto);

            CustomerDto customerDto = customerService.search(custidText.getText());
            rentDto.setCustomerDto(customerDto);

            rentService.saveRent(rentDto);
        }catch (RuntimeException e){
              e.printStackTrace();
        }

    }
}
