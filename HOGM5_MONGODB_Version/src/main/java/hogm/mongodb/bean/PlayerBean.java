package hogm.mongodb.bean;

import hogm.mongodb.entities.Player;
import hogm.mongodb.helper.Helper;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anghel Leonard
 */
@Named("bean")
@Stateless
public class PlayerBean {

    @PersistenceContext(unitName = "HOGM_MONGODB_VERSION-ejbPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    Player p1 = null;
    Player p2 = null;

    public void persistAction() {

        int data = new Random().nextInt(9);

        Player player = new Player();
        player.setName(Helper.NAMES[data]);
        player.setSurname(Helper.SURNAMES[data]);
        player.setAge(Helper.AGES[data]);
        player.setFacade(new Random().nextInt(1000000));

        em.persist(player);
        
        LOG.log(Level.INFO, "Player successfully persisted ...");
    }

    public void readUpdateAction() {

        p1 = em.find(Player.class, 1, LockModeType.OPTIMISTIC);

        if (p1 != null) {
            p1.setFacade(new Random().nextInt(1000000));

            em.merge(p1);           
            em.flush();      
            
            LOG.log(Level.INFO, "UPDATED, version={0}", p1.getVersion());
        }
    }

    //******** TEST OPTIMISTIC LOCKING FOR LockModeType.OPTIMISTIC ********//
    public void read_OPTIMISTIC_Action_1() {
        p1 = em.find(Player.class, 1, LockModeType.OPTIMISTIC);        
        LOG.log(Level.INFO, "READ 1, version={0}", p1.getVersion());
    }

    public void read_OPTIMISTIC_Action_2() {
        p2 = em.find(Player.class, 1, LockModeType.OPTIMISTIC);   
        LOG.log(Level.INFO, "READ 2, version={0}", p2.getVersion());
    }

    public void update_OPTIMISTIC_Action_1() {
        p1.setFacade(new Random().nextInt(1000000));
        em.merge(p1);
        em.flush();
        p1 = em.find(Player.class, 1, LockModeType.OPTIMISTIC);
        LOG.log(Level.INFO, "UPDATE 1, version={0}", p1.getVersion());
    }

    public void update_OPTIMISTIC_Action_2() {
        LOG.log(Level.INFO, "UPDATE 2, version={0}", p2.getVersion());
        p2.setFacade(new Random().nextInt(1000000));       
        em.merge(p2);      
        em.flush();
        //there is no need to check version, until now the OptimisticLockException exception should be in log
    }
    //****************************************************************************************************//  
}
