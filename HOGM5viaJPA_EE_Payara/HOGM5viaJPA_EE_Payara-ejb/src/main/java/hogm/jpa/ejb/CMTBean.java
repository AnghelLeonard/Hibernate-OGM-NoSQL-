package hogm.jpa.ejb;

import hogm.jpa.entities.LuckyNumberEntity;
import java.util.Random;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Named("bean")
public class CMTBean {

    private static final Logger LOG = Logger.getLogger(CMTBean.class.getName());        

    @PersistenceContext(unitName = "HOGM_JPA_PU")
    private EntityManager em;

    public void persistAction() {
        LuckyNumberEntity luckyNumberEntity = new LuckyNumberEntity();
        luckyNumberEntity.setLuckynumber(new Random().nextInt(1000000));

        em.persist(luckyNumberEntity);
        
        LOG.info("Lucky number was successfully persisted ...");
    }        
}
