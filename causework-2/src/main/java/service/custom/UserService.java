package service.custom;

import dto.UserDto;
import service.SuperService;

public interface UserService extends SuperService {
    void saveUser(UserDto userDto);
}
