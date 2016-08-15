package hogm.mongodb.bean;

import hogm.mongodb.entities.Player;
import hogm.mongodb.entities.Tournament;
import hogm.mongodb.helper.Helper;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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

    @PersistenceContext(unitName = "HOGM_ManyToMany-ejbPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    public void persistAction() {

        LOG.info("Trying to persist random players ...");

        int data_1 = new Random().nextInt(9);
        int data_2 = new Random().nextInt(9);
        int data_3 = new Random().nextInt(9);
        
        Tournament t_1 = new Tournament();
        t_1.setTournament(Helper.TOURNAMENTS[0]);
        Tournament t_2 = new Tournament();
        t_2.setTournament(Helper.TOURNAMENTS[1]);
        Tournament t_3 = new Tournament();
        t_3.setTournament(Helper.TOURNAMENTS[2]);

        Player p_1 = new Player();
        p_1.setName(Helper.NAMES[data_1]);
        p_1.setSurname(Helper.SURNAMES[data_1]);
        p_1.setAge(Helper.AGES[data_1]);
        p_1.setBirth(java.sql.Date.valueOf(Helper.BIRTHS[data_1]));
        
        Player p_2 = new Player();
        p_2.setName(Helper.NAMES[data_2]);
        p_2.setSurname(Helper.SURNAMES[data_2]);
        p_2.setAge(Helper.AGES[data_2]);
        p_2.setBirth(java.sql.Date.valueOf(Helper.BIRTHS[data_2]));
        
        Player p_3 = new Player();
        p_3.setName(Helper.NAMES[data_3]);
        p_3.setSurname(Helper.SURNAMES[data_3]);
        p_3.setAge(Helper.AGES[data_3]);
        p_3.setBirth(java.sql.Date.valueOf(Helper.BIRTHS[data_3]));
        
        t_1.addPlayer(p_1);
        t_1.addPlayer(p_2);
        t_1.addPlayer(p_3);
        
        t_2.addPlayer(p_2);
        t_2.addPlayer(p_3);
        
        t_3.addPlayer(p_1);
        t_3.addPlayer(p_3);
        
        em.persist(t_1);
        em.persist(t_2);
        em.persist(t_3);
        
        LOG.info("Mission accomplished ...");
    }
}
