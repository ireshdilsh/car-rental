package dao.custom.impl;

import dao.custom.UserDao;
import entity.UserEntity;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public boolean save(UserEntity entity) {

       Transaction transaction=null;

       try (Session session= SessionFactoryConfiguration.getInstance().getSession()){
           transaction= session.beginTransaction();

           session.save(entity);
           transaction.commit();
           new Alert(Alert.AlertType.INFORMATION,"User save Success").show();
           return true;

       }catch (Exception e){
          if (transaction!=null){
              transaction.rollback();
             new Alert(Alert.AlertType.ERROR,"user save error").show();
          }

       }return false;
    }

    @Override
    public boolean update(UserEntity entity) {
        return false;
    }

    @Override
    public String generateNewId() {
        return null;
    }

    @Override
    public boolean delete(UserEntity entity) {
        return false;
    }

    @Override
    public UserEntity search(String id) {
        return null;
    }

    @Override
    public UserEntity findById(String id) {
        return null;
    }
}
