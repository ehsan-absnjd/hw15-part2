package dao;

import entity.Employee;

public class EmployeeDao extends BaseDao<Employee, Long> {
    @Override
    protected void setEntityClass() {
        this.entityClass=Employee.class;
    }
}
