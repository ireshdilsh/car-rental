package service;


import service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        if (serviceFactory==null){
            serviceFactory=new ServiceFactory();
        }else {}
        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case CAR:
                return new CarServiceImpl();
            case RENT:
                return new RentServiceImpl();
            case CATEGORY:
                return new CarCategoryServiceImpl();
            case USER:
                return new UserServiceImpl();
            default:
                return null;
        }
    }
    public enum ServiceType{
        USER,CUSTOMER,CATEGORY,CAR,RENT
    }
}
