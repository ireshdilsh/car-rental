package service.custom.impl;

import dao.DaoFactory;
import dao.custom.UserDao;
import dto.UserDto;
import entity.UserEntity;
import javafx.scene.control.Alert;
import service.custom.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao= (UserDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.USER);
    @Override
    public void saveUser(UserDto userDto) {
        UserEntity userEntity=new UserEntity();

       userEntity.setId(userDto.getId());
       userEntity.setName(userDto.getName());
       userEntity.setEmail(userDto.getEmail());
       userEntity.setAddress(userDto.getAddress());
       userEntity.setUsername(userDto.getUsername());
       userEntity.setPassword(userDto.getPassword());

      boolean isAdded= userDao.save(userEntity);

      if (isAdded){
          new Alert(Alert.AlertType.INFORMATION,"User add Success").show();
      }else {
          new Alert(Alert.AlertType.ERROR,"User add fail").show();
      }
    }
}
