package service.custom.impl;

import dao.DaoFactory;
import dao.custom.CustomerDao;
import dto.CustomerDto;
import entity.CustomerEntity;
import javafx.scene.control.Alert;
import service.custom.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao= (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity=new CustomerEntity();

        customerEntity.setCustid(customerDto.getCustid());
        customerEntity.setNic(customerDto.getNic());
        customerEntity.setName(customerDto.getName());
        customerEntity.setAddress(customerDto.getAddress());
        customerEntity.setMobileno(customerDto.getMobileno());

        boolean isAdded= customerDao.save(customerEntity);

        if (isAdded){
            new Alert(Alert.AlertType.INFORMATION,"Customer Save Success").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Customer save Errror").show();
        }
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity=new CustomerEntity();

        customerEntity.setCustid(customerDto.getCustid());
        customerEntity.setNic(customerDto.getNic());
        customerEntity.setName(customerDto.getName());
        customerEntity.setAddress(customerDto.getAddress());
        customerEntity.setMobileno(customerDto.getMobileno());

        boolean isUpdate= customerDao.update(customerEntity);

        if (isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Customer update Success").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Customer update Errror").show();
        }
    }

    @Override
    public CustomerDto search(String id) {
        CustomerEntity customerEntity=customerDao.search(id);
        CustomerDto customerDto=new CustomerDto();

        customerDto.setCustid(customerEntity.getCustid());
        customerDto.setName(customerEntity.getName());
        customerDto.setNic(customerEntity.getNic());
        customerDto.setMobileno(customerEntity.getMobileno());
        customerDto.setAddress(customerEntity.getAddress());

        return customerDto;
    }

    @Override
    public void deleteCustomer(CustomerDto dto) {
        try {
            CustomerEntity customerEntity = customerDao.findById(dto.getCustid());

            if (customerEntity != null) {
                boolean isDeleted = customerDao.delete(customerEntity);

                if (isDeleted) {

                    new Alert(Alert.AlertType.INFORMATION,"Delete Success").show();
                } else {

                    new Alert(Alert.AlertType.ERROR,"Delete Fail").show();
                }
            } else {

                new Alert(Alert.AlertType.WARNING,"customer not found").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
