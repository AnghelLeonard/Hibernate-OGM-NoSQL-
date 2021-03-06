package hogm.spring.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Anghel Leonard
 */
@Repository
@Transactional
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDAOImpl() {
        // NOPE
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public T persist(T entity) {
        entityManager.persist(entity);
        return entity;
    }
}
