package service;


import dao.AccountDao;
import entity.Account;

public class AccountService extends BaseService<Account,Long> {
    @Override
    protected void setDao() {
        this.dao=new AccountDao();
    }

}
