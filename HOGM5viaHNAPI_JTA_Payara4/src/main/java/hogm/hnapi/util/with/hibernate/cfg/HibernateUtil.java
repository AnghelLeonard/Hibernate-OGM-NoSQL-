package hogm.hnapi.util.with.hibernate.cfg;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.cfg.OgmConfiguration;

/**
 * HibernateUtil class (based on hibernate.cfg.xml)
 *
 */
public class HibernateUtil {

    private static final Logger LOG = Logger.getLogger(HibernateUtil.class.getName());
    private static final OgmSessionFactory ogmSessionFactory;

    static {
        try {
            // create a new instance of OmgConfiguration
            OgmConfiguration cfgogm = new OgmConfiguration();

            // process configuration and mapping files
            cfgogm.configure();

            // build the session factoy
            ogmSessionFactory = cfgogm.buildSessionFactory();
        } catch (Throwable ex) {
            LOG.log(Level.SEVERE, "Initial SessionFactory creation failed !", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Get the OgmSessionFactory
     *
     * @return OgmSessionFactory
     */
    public static OgmSessionFactory getOgmSessionFactory() {
        return ogmSessionFactory;
    }
}
