package service.custom;

import dto.RentDto;
import service.SuperService;

public interface RentService extends SuperService {

    void saveRent(RentDto rentDto);
}
