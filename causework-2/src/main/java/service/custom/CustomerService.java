package service.custom;

import dto.CustomerDto;
import service.SuperService;

public interface CustomerService extends SuperService {
    void saveCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

    CustomerDto search(String id);


    void deleteCustomer(CustomerDto dto);
}
