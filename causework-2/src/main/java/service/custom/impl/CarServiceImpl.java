package service.custom.impl;

import dao.DaoFactory;
import dao.custom.CarCategoryDao;
import dao.custom.CarDao;
import dto.CarDto;
import entity.CarCategoryEntity;
import entity.CarEntity;
import javafx.scene.control.Alert;
import service.custom.CarService;


public class CarServiceImpl implements CarService {
    CarDao carDao= (CarDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CAR);
    CarCategoryDao carCategoryDao= (CarCategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CATEGORY);

    @Override
    public void saveCar(CarDto carDto) {

        CarEntity carEntity = new CarEntity();
        carEntity.setCarid(carDto.getCarid());
        carEntity.setBrand(carDto.getBrand());
        carEntity.setModel(carDto.getModel());
        carEntity.setYear(carDto.getYear());
        carEntity.setVehino(carDto.getVehino());
        carEntity.setPriceperday(carDto.getPriceperday());

        CarCategoryEntity carCategoryEntity = carCategoryDao.findById(carDto.getCarCategoryDto().getCategoryid());
        carEntity.setCarCategoryEntity(carCategoryEntity);

        boolean isAdd= carDao.save(carEntity);

        if (isAdd){
            new Alert(Alert.AlertType.INFORMATION,"Car Add Success").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Car Add fail").show();
        }
    }

    @Override
    public void updateCar(CarDto carDto) {

        CarEntity carEntity = new CarEntity();
        carEntity.setCarid(carDto.getCarid());
        carEntity.setBrand(carDto.getBrand());
        carEntity.setModel(carDto.getModel());
        carEntity.setYear(carDto.getYear());
        carEntity.setVehino(carDto.getVehino());
        carEntity.setPriceperday(carDto.getPriceperday());

        CarCategoryEntity carCategoryEntity = new CarCategoryEntity();
        carCategoryEntity.setCategoryid(carDto.getCarCategoryDto().getCategoryid());
        carCategoryEntity.setName(carDto.getCarCategoryDto().getName());
        carEntity.setCarCategoryEntity(carCategoryEntity);

        boolean isUpdate= carDao.update(carEntity);

        if (isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Car update Success").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Car Update Cancel").show();
        }
    }


    @Override
    public void deleteCar(CarDto dto) {
        try {
            CarEntity carEntity = carDao.findById(dto.getCarid());

            if (carEntity != null) {
                boolean isDeleted = carDao.delete(carEntity);

                if (isDeleted) {
                 //   return "SUCCESS";
                } else {
                   // return "FAILURE";
                }
            } else {
             //   return "NOT_FOUND";
            }
        } catch (Exception e) {
            e.printStackTrace();
            //return "ERROR";
        }
    }

    @Override
    public CarDto searchCar(String id) {
        CarEntity carEntity = carDao.search(id);
        CarDto carDto = new CarDto();
        carDto.setCarid(carEntity.getCarid());
        carDto.setBrand(carEntity.getBrand());
        carDto.setModel(carEntity.getModel());
        carDto.setVehino(carEntity.getVehino());
        carDto.setYear(carEntity.getYear());
        carDto.setPriceperday(carEntity.getPriceperday());
        return carDto;
    }
}
