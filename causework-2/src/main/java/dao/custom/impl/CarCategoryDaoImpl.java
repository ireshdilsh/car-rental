package dao.custom.impl;

import dao.custom.CarCategoryDao;
import entity.CarCategoryEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.custom.impl.CarCategoryServiceImpl;
import util.SessionFactoryConfiguration;

import java.util.List;

public class CarCategoryDaoImpl implements CarCategoryDao {
    @Override
    public List<CarCategoryEntity> getAll() {
        return null;
    }

    @Override
    public boolean save(CarCategoryEntity entity) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            return true;
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(CarCategoryEntity entity) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(entity);
            transaction.commit();
            return true;
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public String generateNewId() {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query  query = session.createQuery("SELECT categoryid FROM car_category ORDER BY categoryid DESC");
            query.setMaxResults(1);
            List results = query.list();
            transaction.commit();
            return (results.size()==0) ? null : (String) results.get(0);
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return "0";
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(CarCategoryEntity entity) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(entity);
            transaction.commit();
            return true;
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public CarCategoryEntity search(String id) {

        Transaction transaction=null;
        CarCategoryEntity carCategoryEntity = null;
        try (Session session = SessionFactoryConfiguration.getInstance().getSession()){
            transaction = session.beginTransaction();
            carCategoryEntity = session.get(CarCategoryEntity.class,id);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){transaction.rollback();
            }
        }
        return carCategoryEntity;
    }

    @Override
    public CarCategoryEntity findById(String id) {

        try (Session session = SessionFactoryConfiguration.getInstance().getSession()) {
            return session.get(CarCategoryEntity.class, id);
        } catch (Exception e) {
            return null;
        }
    }
}
