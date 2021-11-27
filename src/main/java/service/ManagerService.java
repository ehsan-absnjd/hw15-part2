package service;

import dao.ManagerDao;
import entity.Manager;

public class ManagerService extends BaseService<Manager,Long> {
    @Override
    protected void setDao() {
        this.dao = new ManagerDao();
    }
}
