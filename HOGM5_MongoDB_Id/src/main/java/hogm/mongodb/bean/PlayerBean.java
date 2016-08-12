package hogm.mongodb.bean;

import hogm.mongodb.entities.PlayerCustom;
import hogm.mongodb.entities.PlayerEmbeddedId;
import hogm.mongodb.entities.PlayerIdClass;
import hogm.mongodb.entities.PlayerIdentity;
import hogm.mongodb.entities.PlayerManual;
import hogm.mongodb.entities.PlayerSequence;
import hogm.mongodb.entities.PlayerTable;
import hogm.mongodb.entities.PlayerUuid2;
import hogm.mongodb.entities.RankingAndPrizeEmbeddedPK;
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

    @PersistenceContext(unitName = "HOGM_MONGODB_Id-ejbPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    public void persistAction() {

        LOG.info("Trying to persist random players ...");

        int data = new Random().nextInt(9);

        //*** Manually set primary keys ****
        PlayerManual player_1 = new PlayerManual();
        player_1.setId(1);
        player_1.setName(Helper.NAMES[1]);
        player_1.setSurname(Helper.SURNAMES[1]);
        player_1.setAge(Helper.AGES[1]);

        PlayerManual player_2 = new PlayerManual();
        player_2.setId(2);
        player_2.setName(Helper.NAMES[2]);
        player_2.setSurname(Helper.SURNAMES[2]);
        player_2.setAge(Helper.AGES[2]);

        PlayerManual player_3 = new PlayerManual();
        player_3.setId(3);
        player_3.setName(Helper.NAMES[3]);
        player_3.setSurname(Helper.SURNAMES[3]);
        player_3.setAge(Helper.AGES[3]);

        em.persist(player_1);
        em.persist(player_2);
        em.persist(player_3);
        //**********************************

        //*** AUTO ***       
        /*
        PlayerAUTO player_auto = new PlayerAUTO();
        player_auto.setName(Helper.NAMES[data]);
        player_auto.setSurname(Helper.SURNAMES[data]);
        player_auto.setAge(Helper.AGES[data]);

        em.persist(player_auto);
         */
        //************
        //*** IDENTITY ***
        PlayerIdentity player_identity = new PlayerIdentity();
        player_identity.setName(Helper.NAMES[data]);
        player_identity.setSurname(Helper.SURNAMES[data]);
        player_identity.setAge(Helper.AGES[data]);

        em.persist(player_identity);
        //****************

        //*** SEQUENCE ***
        PlayerSequence player_sequence = new PlayerSequence();
        player_sequence.setName(Helper.NAMES[data]);
        player_sequence.setSurname(Helper.SURNAMES[data]);
        player_sequence.setAge(Helper.AGES[data]);

        em.persist(player_sequence);
        //****************

        //*** TABLE ***
        PlayerTable player_table = new PlayerTable();
        player_table.setName(Helper.NAMES[data]);
        player_table.setSurname(Helper.SURNAMES[data]);
        player_table.setAge(Helper.AGES[data]);

        em.persist(player_table);
        //*************

        //*** UUID2 ***
        PlayerUuid2 player_uuid2 = new PlayerUuid2();
        player_uuid2.setName(Helper.NAMES[data]);
        player_uuid2.setSurname(Helper.SURNAMES[data]);
        player_uuid2.setAge(Helper.AGES[data]);

        em.persist(player_uuid2);
        //*************

        //***Custom Generator ***
        PlayerCustom player_custom = new PlayerCustom();
        player_custom.setName(Helper.NAMES[data]);
        player_custom.setSurname(Helper.SURNAMES[data]);
        player_custom.setAge(Helper.AGES[data]);

        em.persist(player_custom);
        //***********************

        //*** Composite Key (EmbeddedId) ***
        RankingAndPrizeEmbeddedPK id = new RankingAndPrizeEmbeddedPK();
        id.setRanking(Helper.RANKINS[data]);
        id.setPrize(Helper.PRIZES[data]);

        PlayerEmbeddedId player_embeddedid = new PlayerEmbeddedId();
        player_embeddedid.setId(id);
        player_embeddedid.setName(Helper.NAMES[data]);
        player_embeddedid.setSurname(Helper.SURNAMES[data]);
        player_embeddedid.setAge(Helper.AGES[data]);

        em.persist(player_embeddedid);
        //***********************************

        //*** Composite Key (IdClass) ***        
        PlayerIdClass player_idclass = new PlayerIdClass();
        player_idclass.setRanking(Helper.RANKINS[data]);
        player_idclass.setPrize(Helper.PRIZES[data]);
        player_idclass.setName(Helper.NAMES[data]);
        player_idclass.setSurname(Helper.SURNAMES[data]);
        player_idclass.setAge(Helper.AGES[data]);

        em.persist(player_idclass);
        //************************************       
        
        LOG.info("Mission accomplished ...");
    }
}
