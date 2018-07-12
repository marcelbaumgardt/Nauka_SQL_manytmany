package pl.marcelbaumgardt.naukasqlmanytmany.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;

@Transactional
public abstract class GenericDao<T,K> {

    @PersistenceContext
    EntityManager entityManager;
    private Class<T> type; //Customer.class

    public GenericDao() {
        this.type = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }



    public void save(T entity){

        entityManager.persist(entity);
    }

    public T get(K key){
        return entityManager.find(type, key);
    }


}


