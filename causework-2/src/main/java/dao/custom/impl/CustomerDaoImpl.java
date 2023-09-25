package dao.custom.impl;

import dao.custom.CustomerDao;
import entity.CarCategoryEntity;
import entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.SessionFactoryConfiguration;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    Transaction transaction=null;
    @Override
    public List<CustomerEntity> getAll() {
        return null;
    }

    @Override
    public boolean save(CustomerEntity entity) {

        try (Session session= SessionFactoryConfiguration.getInstance().getSession()){
            transaction= session.beginTransaction();

            session.save(entity);
            transaction.commit();
            return true;

        }catch (Exception e){

            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(CustomerEntity entity) {
        try (Session session= SessionFactoryConfiguration.getInstance().getSession()){
            transaction= session.beginTransaction();

            session.update(entity);
            transaction.commit();
            return true;

        }catch (Exception e){

            transaction.rollback();
            return false;
        }
    }

    @Override
    public String generateNewId() {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session.createQuery("SELECT id FROM customer ORDER BY id DESC");
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
    public boolean delete(CustomerEntity entity) {
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
    public CustomerEntity search(String id) {
      CustomerEntity customerEntity=null;
      try (Session session=SessionFactoryConfiguration.getInstance().getSession()){
          transaction= session.beginTransaction();
          customerEntity=session.get(CustomerEntity.class,id);
          transaction.commit();
      }catch (Exception e){
          transaction.rollback();
          e.printStackTrace();
      }
      return customerEntity;
    }

    @Override
    public CustomerEntity findById(String id) {
        try (Session session = SessionFactoryConfiguration.getInstance().getSession()) {
            return session.get(CustomerEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
