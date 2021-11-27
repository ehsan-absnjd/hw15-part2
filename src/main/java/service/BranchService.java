package service;

import dao.BaseDao;
import dao.BranchDao;
import entity.Branch;

public class BranchService extends BaseService<Branch,Long> {
    @Override
    protected void setDao() {
        this.dao=new BranchDao();
    }
}
