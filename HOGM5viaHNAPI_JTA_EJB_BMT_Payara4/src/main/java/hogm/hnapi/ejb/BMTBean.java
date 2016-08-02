package hogm.hnapi.ejb;

import hogm.hnapi.pojo.LuckyNumberEntity;
import hogm.hnapi.pojo.LuckyNumberPojo;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.jboss.logging.Logger;

@Stateless
@Named("bean")
@TransactionManagement(TransactionManagementType.BEAN)
public class BMTBean {

    @Resource
    private UserTransaction userTransaction;
    
    private static final Logger LOG = Logger.getLogger(BMTBean.class.getName());

    public void persistAction() {

        LOG.info("Persisting LuckyNumberEntity instance ...");       
        LuckyNumberEntity luckyNumberEntity = new LuckyNumberEntity();
        luckyNumberEntity.setLuckynumber(new Random().nextInt(1000000));
        LuckyNumberPojo luckyNumberPojo = new LuckyNumberPojo();
        luckyNumberPojo.setLuckynumber(new Random().nextInt(1000000));

        try {            
            // Start the transaction
            userTransaction.begin();

            hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getOgmSessionFactory().
                    getCurrentSession().persist(luckyNumberEntity);
            hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getOgmSessionFactory().
                    getCurrentSession().persist(luckyNumberPojo);

            // Commit the transaction
            userTransaction.commit();
        } catch (Exception ex) {
            try {
                //Rollback the transaction
                userTransaction.setRollbackOnly();
            } catch (IllegalStateException ex1) {
                LOG.log(Logger.Level.ERROR, ex1, ex1);
            } catch (SystemException ex1) {
                LOG.log(Logger.Level.ERROR, ex1, ex1);
            }
        }
        LOG.info("Persist successful ...");
    }
}
