package dao;

import entity.Branch;

public class BranchDao extends BaseDao<Branch,Long> {
    @Override
    protected void setEntityClass() {
        this.entityClass=Branch.class;
    }
}
