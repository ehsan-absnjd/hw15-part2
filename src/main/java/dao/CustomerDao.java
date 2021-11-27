package dao;

import entity.Customer;

public class CustomerDao extends BaseDao<Customer , Long>{


    @Override
    protected void setEntityClass() {
        this.entityClass = Customer.class;
    }
}
