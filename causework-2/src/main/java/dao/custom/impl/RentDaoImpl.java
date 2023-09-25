package dao.custom.impl;

import dao.custom.RentDao;
import entity.RentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

import java.util.List;

public class RentDaoImpl implements RentDao {
    @Override
    public List<RentEntity> getAll() {
        return null;
    }

    @Override
    public boolean save(RentEntity entity) {

        Transaction transaction=null;

        try (Session session= SessionFactoryConfiguration.getInstance().getSession()){
            transaction= session.beginTransaction();

            session.save(entity);
            transaction.commit();
            return true;

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(RentEntity entity) {
        return false;
    }

    @Override
    public String generateNewId() {
        return null;
    }

    @Override
    public boolean delete(RentEntity entity) {
        return false;
    }

    @Override
    public RentEntity search(String id) {
        return null;
    }

    @Override
    public RentEntity findById(String customerId) {
        return null;
    }
}
