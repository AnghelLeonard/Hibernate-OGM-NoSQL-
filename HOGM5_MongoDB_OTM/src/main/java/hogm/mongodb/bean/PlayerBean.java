package hogm.mongodb.bean;

import hogm.mongodb.entities.Photo;
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

    @PersistenceContext(unitName = "HOGM_OneToMany-ejbPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    public void persistAction() {

        LOG.info("Trying to persist random players ...");

        int data = new Random().nextInt(9);

        Player player = new Player();

        player.setName(Helper.NAMES[data]);
        player.setSurname(Helper.SURNAMES[data]);
        player.setAge(Helper.AGES[data]);
        player.setBirth(java.sql.Date.valueOf(Helper.BIRTHS[data]));

        int i = 0;        
        try {
            while (true) {
                Photo photo = new Photo();
                photo.setPhoto(Helper.PHOTOS[data][i]);
                player.addPhoto(photo);
                i++;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
     
        em.persist(player);

        LOG.info("Mission accomplished ...");
    }
}
