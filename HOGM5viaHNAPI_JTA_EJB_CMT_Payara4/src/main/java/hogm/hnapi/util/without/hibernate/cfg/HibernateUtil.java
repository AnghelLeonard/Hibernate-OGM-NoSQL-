package hogm.hnapi.util.without.hibernate.cfg;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmProperties;
import org.hibernate.ogm.datastore.mongodb.MongoDB;

/**
 * HibernateUtil class (no need of hibernate.cfg.xml)
 *
 */
public class HibernateUtil {

    private static final Logger LOG = Logger.getLogger(HibernateUtil.class.getName());
    private static final OgmSessionFactory ogmSessionFactory;

    static {
        try {

            // create the StandardServiceRegistry
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySetting(OgmProperties.ENABLED, true)
                    // assuming you are using JTATransactionFactory
                    .applySetting(AvailableSettings.TRANSACTION_COORDINATOR_STRATEGY, "org.hibernate.transaction.CMTTransactionFactory")
                    // configure current session context
                    .applySetting(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "jta")
                    // set JTA platform
                    .applySetting(AvailableSettings.JTA_PLATFORM, "org.hibernate.service.jta.platform.internal.SunOneJtaPlatform")
                    // assuming MongoDB as the backend
                    .applySetting(OgmProperties.DATASTORE_PROVIDER, MongoDB.DATASTORE_PROVIDER_NAME)                    
                    .applySetting(OgmProperties.DATABASE, "payara_db")
                    .applySetting(OgmProperties.CREATE_DATABASE, "true")
                    .applySetting(OgmProperties.HOST, "127.0.0.1:27017")
                    .build();

            ogmSessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(hogm.hnapi.pojo.LuckyNumberEntity.class)
                    .buildMetadata()
                    .getSessionFactoryBuilder()
                    .unwrap(OgmSessionFactoryBuilder.class)
                    .build();

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
