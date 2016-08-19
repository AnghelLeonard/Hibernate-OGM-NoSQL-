package hogm.mongodb.bean;

import hogm.mongodb.entities.BaseballPlayer;
import hogm.mongodb.entities.TennisPlayer;
import hogm.mongodb.helper.Helper;
import java.util.ArrayList;
import java.util.List;
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

    @PersistenceContext(unitName = "HOGM_MONGODB_LISTENERS-ejbPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    private List tennispklist = new ArrayList();
    private List baseballpklist = new ArrayList();

    public void persistTenisPlayerAction() {

        int data = new Random().nextInt(9);

        TennisPlayer player = new TennisPlayer();
        player.setName(Helper.NAMES[data]);
        player.setSurname(Helper.SURNAMES[data]);
        player.setAge(Helper.AGES[data]);
        player.setBirth(java.sql.Date.valueOf(Helper.BIRTHS[data]));
        player.setHandplay(Helper.PLAYS[data]);

        em.persist(player);

        tennispklist.add(player.getId());
    }

    public void persistBaseballPlayerAction() {

        int data = new Random().nextInt(5);

        BaseballPlayer player = new BaseballPlayer();
        player.setName(Helper.BNAMES[data]);
        player.setSurname(Helper.BSURNAMES[data]);
        player.setAge(Helper.BAGES[data]);
        player.setBirth(java.sql.Date.valueOf(Helper.BBIRTHS[data]));
        player.setPosition(Helper.BPOSITIONS[data]);

        em.persist(player);

        baseballpklist.add(player.getId());
    }

    public void loadFirstTennisPlayer() {
        if (!tennispklist.isEmpty()) {
            em.find(TennisPlayer.class, tennispklist.get(0));
        } else {
            LOG.info("THERE ARE NO MORE TENNIS PLAYERS IN THE DATABASE ...");
        }
    }

    public void loadFirstBaseballPlayer() {
        if (!baseballpklist.isEmpty()) {
            em.find(BaseballPlayer.class, baseballpklist.get(0));
        } else {
            LOG.info("THERE ARE NO MORE BASEBALL PLAYERS IN THE DATABASE ...");
        }
    }

    public void updateFirstTennisPlayer() {
        if (!tennispklist.isEmpty()) {
            TennisPlayer first = em.find(TennisPlayer.class, tennispklist.get(0));
            if (first != null) {
                first.setHandplay("Left-handed");                
            }
        } else {
            LOG.info("THERE ARE NO MORE TENNIS PLAYERS IN THE DATABASE ...");
        }
    }

    public void updateFirstBaseballPlayer() {
        if (!baseballpklist.isEmpty()) {
            BaseballPlayer first = em.find(BaseballPlayer.class, baseballpklist.get(0));
            if (first != null) {
                first.setPosition("reserve");                
            }
        } else {
            LOG.info("THERE ARE NO MORE BASEBALL PLAYERS IN THE DATABASE ...");
        }
    }

    public void deleteFirstTennisPlayer() {
        if (!tennispklist.isEmpty()) {
            TennisPlayer first = em.find(TennisPlayer.class, tennispklist.get(0));
            if (first != null) {
                em.remove(first);
                tennispklist.remove(0);
            }
        } else {
            LOG.info("THERE ARE NO MORE TENNIS PLAYERS IN THE DATABASE ...");
        }
    }

    public void deleteFirstBaseballPlayer() {
        if (!baseballpklist.isEmpty()) {
            BaseballPlayer first = em.find(BaseballPlayer.class, baseballpklist.get(0));
            if (first != null) {
                em.remove(first);
                baseballpklist.remove(0);
            }
        } else {
            LOG.info("THERE ARE NO MORE BASEBALL PLAYERS IN THE DATABASE ...");
        }
    }
}
