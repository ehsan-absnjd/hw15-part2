package dao;

import entity.Account;

public class AccountDao extends BaseDao<Account, Long> {
    @Override
    protected void setEntityClass() {
        this.entityClass=Account.class;
    }
}
