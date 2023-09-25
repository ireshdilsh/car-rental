package service.custom.impl;

import dao.DaoFactory;
import dao.custom.CarDao;
import dao.custom.CustomerDao;
import dao.custom.RentDao;
import dto.RentDto;
import entity.CarEntity;
import entity.CustomerEntity;
import entity.RentEntity;
import javafx.scene.control.Alert;
import service.custom.RentService;

public class RentServiceImpl implements RentService {

    CarDao carDao= (CarDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CAR);
    CustomerDao customerDao= (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);
    RentDao rentDao= (RentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.RENT);

    @Override
    public void saveRent(RentDto rentDto) {
        try {

            RentEntity rentEntity = new RentEntity();
            rentEntity.setRentid(rentDto.getRentid());
            rentEntity.setFrom_date(rentDto.getFrom_date());
            rentEntity.setTo_date(rentDto.getTo_date());
            rentEntity.setIsreturn(rentDto.isIsreturn());
            rentEntity.setPerdayrent(rentDto.getPerdayrent());
            rentEntity.setTotal(rentDto.getTotal());
            rentEntity.setBalance(rentDto.getBalance());

            CarEntity carEntity = carDao.findById(rentDto.getCarDto().getCarid());
            rentEntity.setCarEntity(carEntity);

            CustomerEntity customerEntity = customerDao.findById(rentDto.getCustomerDto().getCustid());
            rentEntity.setCustomerEntity(customerEntity);

            boolean isAdd = rentDao.save(rentEntity);

            if (isAdd) {
                new Alert(Alert.AlertType.INFORMATION, "Rent add success").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Rent add fail").show();
            }
        }catch (Exception e){
             e.printStackTrace();
        }
    }

}
