package dao;


import dao.custom.impl.*;

public class DaoFactory {
private DaoFactory(){}
    private static DaoFactory daoFactory;

public static DaoFactory getInstance(){
    if (daoFactory==null){
        daoFactory=new DaoFactory();
    }else{}return daoFactory;
}
public SuperDao getDao(DaoType type){
    switch (type){
        case CUSTOMER:
            return new CustomerDaoImpl();
        case CAR:
            return new CarDaoImpl();
        case RENT:
            return new RentDaoImpl();
        case CATEGORY:
            return new CarCategoryDaoImpl();
        case USER:
            return new UserDaoImpl();
        default:
            return null;
    }
}
public enum DaoType{
    USER,CUSTOMER,CATEGORY,CAR,RENT
}
}
