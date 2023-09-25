package service.custom;

import dto.CarDto;
import service.SuperService;


public interface CarService extends SuperService {
    void saveCar(CarDto carDto);

    void updateCar(CarDto carDto);



    void deleteCar(CarDto dto);

    CarDto searchCar(String text);
}
