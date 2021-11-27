package service;

import dao.BaseDao;
import entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public abstract class BaseService <T extends BaseEntity<ID> , ID extends Number >{
    protected BaseDao dao ;

    public BaseService() {
        setDao();
    }
    protected abstract void setDao();

    public Optional<T> fincById(ID id){
        return dao.findById(id);
    }

    public List<T> findAll(){
        return dao.findAll();
    }

    public void delete(T entity){
        dao.getTransaction().begin();
        dao.delete(entity);
        dao.getTransaction().commit();
    }

    public void saveOrUpdate (T entity){
        dao.getTransaction().begin();
        dao.saveOrUpdate(entity);
        dao.getTransaction().commit();
    }
}
