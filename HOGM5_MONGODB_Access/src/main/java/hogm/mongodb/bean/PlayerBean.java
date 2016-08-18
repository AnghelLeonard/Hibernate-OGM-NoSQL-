package hogm.mongodb.bean;

import hogm.mongodb.entities.Detail;
import hogm.mongodb.entities.Player;
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

    @PersistenceContext(unitName = "HOGM_MONGODB_ACCESS-ejbPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    public void persistAction() {

        LOG.info("Trying to persist random players ...");

       int data = new Random().nextInt(9);

        Player player = new Player();
        Detail detail = new Detail();
        
        detail.setBirthplace(Helper.BIRTHPLACES[data]);
        detail.setCoach(Helper.COACHS[data]);
        detail.setHeight(Helper.HEIGHTS[data]);
        detail.setPlays(Helper.PLAYS[data]);
        detail.setResidence(Helper.RESIDENCES[data]);
        detail.setTurnedpro(Helper.TURNEDPRO[data]);
        detail.setWebsite(Helper.WEBSITES[data]);
        detail.setWeight(Helper.WEIGHTS[data]);
        
        player.setName(Helper.NAMES[data]);
        player.setSurname(Helper.SURNAMES[data]);
        player.setAge(Helper.AGES[data]);
        player.setBirth(java.sql.Date.valueOf(Helper.BIRTHS[data]));
        
        player.setDetails(detail);

        em.persist(player);

        LOG.info("Mission accomplished ...");
    }
}
