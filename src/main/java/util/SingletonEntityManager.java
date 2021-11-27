package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SingletonEntityManager {
    private static EntityManager entityManager= Persistence
            .createEntityManagerFactory("bank")
            .createEntityManager();
    public static EntityManager getEntityManager(){
        return entityManager;
    }
}
