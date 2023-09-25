package dao.custom.impl;

import dao.custom.CarDao;
import entity.CarEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.SessionFactoryConfiguration;

import java.util.List;

public class CarDaoImpl implements CarDao {
    @Override
    public List<CarEntity> getAll() {
        return null;
    }

    @Override
    public boolean save(CarEntity entity) {

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
    public boolean update(CarEntity entity) {

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
           Query query = session.createQuery("SELECT carid FROM car ORDER BY carid DESC");
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
    public boolean delete(CarEntity entity) {

        Transaction transaction = null;
        try(Session session = SessionFactoryConfiguration.getInstance().getSession()){
            transaction = session.beginTransaction();

            session.delete(entity);
            transaction.commit();
            return true;
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CarEntity search(String id) {

        Transaction transaction=null;
        CarEntity carEntity = null;
        try (Session session = SessionFactoryConfiguration.getInstance().getSession()){
            transaction = session.beginTransaction();
            carEntity = session.get(CarEntity.class,id);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){transaction.rollback();
            }
        }
        return carEntity;
    }

    @Override
    public CarEntity findById(String customerId) {
        return null;
    }
}
