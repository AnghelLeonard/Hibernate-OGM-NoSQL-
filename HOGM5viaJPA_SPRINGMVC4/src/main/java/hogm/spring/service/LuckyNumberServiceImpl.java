package hogm.spring.service;

import hogm.spring.model.LuckyNumberEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import hogm.spring.dao.GenericDAO;

/**
 *
 * @author Anghel Leonard
 */
@Repository
public class LuckyNumberServiceImpl implements LuckyNumberService {

    private static final Logger LOG = Logger.getLogger(LuckyNumberServiceImpl.class.getName());

    @Autowired
    private GenericDAO genericDAO;

    @Override
    @Transactional
    public void persistLuckyNumber(LuckyNumberEntity luckyNumberEntity) {
       
        genericDAO.persist(luckyNumberEntity);

        LOG.log(Level.INFO, "Lucky number successfully persisted ...");
    }
}
