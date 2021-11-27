package service;

import dao.EmployeeDao;
import entity.Employee;

public class EmployeService extends BaseService<Employee,Long> {
    @Override
    protected void setDao() {
        this.dao=new EmployeeDao();
    }
}
