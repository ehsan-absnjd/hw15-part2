package dao;

import entity.BaseEntity;
import util.SingletonEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public abstract class BaseDao<T extends BaseEntity<ID>,ID extends Number > {
    protected Class<T> entityClass;
    protected EntityManager entityManager;

    public BaseDao() {
        entityManager = SingletonEntityManager.getEntityManager();
        setEntityClass();
    }
    protected abstract void setEntityClass();

    public Optional<T> findById(ID id){
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    public void saveOrUpdate(T entity){
        if (entity.getId()==null){
            entityManager.persist(entity);
        }else {
            entityManager.merge(entity);
        }
    }

    public List<T> findAll(){
        Query query = entityManager.createQuery("from " + entityClass.getSimpleName() + " e");
        return query.getResultList();
    }
    public void delete(T entity){
        entityManager.remove(entity);
    }
    public EntityTransaction getTransaction(){
        return entityManager.getTransaction();
    }
}
