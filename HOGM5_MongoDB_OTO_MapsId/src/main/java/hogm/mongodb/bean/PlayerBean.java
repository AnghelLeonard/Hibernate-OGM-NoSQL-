package hogm.mongodb.bean;

import hogm.mongodb.entities.Detail;
import hogm.mongodb.entities.MoreDetails;
import hogm.mongodb.entities.Player;
import hogm.mongodb.entities.Website;
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

    @PersistenceContext(unitName = "HOGM_OneToOne-ejbPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    public void persistAction() {

        LOG.info("Trying to persist random players ...");

        int data = new Random().nextInt(9);

        Player player = new Player();
        Website website = new Website();
        Detail maindetail = new Detail();
        MoreDetails moredetail = new MoreDetails();

        player.setName(Helper.NAMES[data]);
        player.setSurname(Helper.SURNAMES[data]);
        player.setAge(Helper.AGES[data]);
        player.setBirth(java.sql.Date.valueOf(Helper.BIRTHS[data]));
        maindetail.setBirthplace(Helper.BIRTHPLACES[data]);
        maindetail.setCoach(Helper.COACHS[data]);
        maindetail.setHeight(Helper.HEIGHTS[data]);
        maindetail.setPlays(Helper.PLAYS[data]);
        maindetail.setResidence(Helper.RESIDENCES[data]);
        maindetail.setTurnedpro(Helper.TURNEDPRO[data]);
        maindetail.setWeight(Helper.WEIGHTS[data]);
        website.setHttp_address(Helper.WEBSITES[data]);
        moredetail.setPrizes(Helper.PRIZES[data]);
        moredetail.setRanking(Helper.RANKINS[data]);

        maindetail.setMore(moredetail);
        player.setDetails(maindetail);
        website.setPlayer(player);

        em.persist(website);

        LOG.info("Mission accomplished ...");
    }
}
