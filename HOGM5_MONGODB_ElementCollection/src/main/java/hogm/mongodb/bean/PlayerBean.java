package hogm.mongodb.bean;

import hogm.mongodb.entities.Player;
import hogm.mongodb.entities.Wins2012;
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

    @PersistenceContext(unitName = "HOGM_MONGODB_ELEMENTCOLLECTION-ejbPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    public void persistAction() {

        LOG.info("Trying to persist random players ...");

        int data = new Random().nextInt(9);

        Player player = new Player();
        List<Wins2012> wins = new ArrayList();
        List<String> rankingsh = new ArrayList();

        int i = 0;
        try {
            while (true) {
                Wins2012 win = new Wins2012();
                win.setTitlesfinals(Helper.WIN2012[data][i]);
                wins.add(win);
                i++;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // this is a bad-practice, don't do this in production
        }

        i = 0;
        try {
            while (true) {
                String rank = Helper.RANKINS08_12[data][i];
                rankingsh.add(rank);
                i++;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // this is a bad-practice, don't do this in production
        }


        player.setName(Helper.NAMES[data]);
        player.setSurname(Helper.SURNAMES[data]);
        player.setAge(Helper.AGES[data]);
        player.setBirth(java.sql.Date.valueOf(Helper.BIRTHS[data]));
        player.setWins(wins);
        player.setRankinghistory08_12(rankingsh);

        em.persist(player);

        LOG.info("Mission accomplished ...");
    }
}
