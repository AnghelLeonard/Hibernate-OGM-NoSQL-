package hogm.mongodb.bean;

import hogm.mongodb.entities.BaseballPlayer;
import hogm.mongodb.entities.TennisPlayer;
import hogm.mongodb.helper.Helper;
import java.util.Random;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anghel Leonard
 */
@Named("bean")
@Stateless
public class PlayerBean {

    @PersistenceContext(unitName = "HOGM_MONGODB_MAPPEDSUPERCLASS-ejbPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    public void persistTennisPlayerAction() {
        
        int data = new Random().nextInt(9);
        
        LOG.info("Trying to persist random tennis players ...");
        
        TennisPlayer player = new TennisPlayer();
        player.setName(Helper.NAMES[data]);
        player.setSurname(Helper.SURNAMES[data]);
        player.setAge(Helper.AGES[data]);
        player.setBirth(java.sql.Date.valueOf(Helper.BIRTHS[data]));
        player.setHandplay(Helper.PLAYS[data]);
        
        em.persist(player);
        
        LOG.info("Mission accomplished ...");
    }
    
    public void persistBaseballPlayerAction() {
        
        int data = new Random().nextInt(5);
        
        LOG.info("Trying to persist random baseball players ...");        
        
        BaseballPlayer player = new BaseballPlayer();
        player.setName(Helper.BNAMES[data]);
        player.setSurname(Helper.BSURNAMES[data]);
        player.setAge(Helper.BAGES[data]);
        player.setBirth(java.sql.Date.valueOf(Helper.BBIRTHS[data]));
        player.setPosition(Helper.BPOSITIONS[data]);
        
        em.persist(player);
        
        LOG.info("Mission accomplished ...");
    }
}
