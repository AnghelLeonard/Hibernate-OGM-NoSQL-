package sh.simpleconfiguration;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import hogm.spring.service.LuckyNumberServiceImpl;
import hogm.spring.service.LuckyNumberService;
import org.hibernate.ogm.jpa.HibernateOgmPersistence;
import hogm.spring.dao.GenericDAO;
import hogm.spring.dao.GenericDAOImpl;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 *
 * @author Anghel Leonard
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hogm.spring.controllers")
@EnableTransactionManagement
public class SHConfiguration {

    @Bean
    public LuckyNumberService productService() {
        return new LuckyNumberServiceImpl();
    }

    @Bean
    public GenericDAO genericDAO() {
        return new GenericDAOImpl();
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setPersistenceUnitName(getClass().getSimpleName());
        localContainerEntityManagerFactoryBean.setPersistenceProvider(new HibernateOgmPersistence());
        localContainerEntityManagerFactoryBean.setPackagesToScan(packagesToScan());

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaProperties(additionalProperties());
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    protected Properties additionalProperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JTATransactionFactory");
        properties.setProperty("hibernate.current_session_context_class", "jta");
        properties.setProperty("hibernate.transaction.jta.platform", "org.hibernate.service.jta.platform.internal.SunOneJtaPlatform");
        properties.setProperty("hibernate.transaction.manager_lookup_class", "org.hibernate.transaction.SunONETransactionManagerLookup");
        properties.setProperty("hibernate.ogm.datastore.provider", "mongodb");
        properties.setProperty("hibernate.ogm.datastore.create_database", "true");
        properties.setProperty("hibernate.ogm.datastore.database", "spring_db");
        properties.setProperty("hibernate.ogm.mongodb.host", "127.0.0.1");
        properties.setProperty("hibernate.ogm.mongodb.port", "27017");

        return properties;
    }

    protected String[] packagesToScan() {
        return new String[]{
            "hogm.spring.model"
        };
    }
}
