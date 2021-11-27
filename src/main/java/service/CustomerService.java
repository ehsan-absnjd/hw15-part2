package service;

import dao.CustomerDao;
import entity.Customer;

public class CustomerService extends BaseService<Customer,Long>{
    @Override
    protected void setDao() {
        this.dao=new CustomerDao();
    }
}
