package dao;

import entity.Manager;

public class ManagerDao extends BaseDao<Manager,Long> {
    @Override
    protected void setEntityClass() {
        this.entityClass=Manager.class;
    }
}
