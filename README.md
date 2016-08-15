# Hibernate-OGM-NoSQL-

This repo contains examples with Hibernate OGM for MongoDB:

1. Hibernate OGM via Hibernate Native API, non-JTA,  JDBC transaction demarcation
   - For Hibernate OGM 4.0.0.Beta2 (app name: **HOGM4viaHNAPI_JDBC_Tomcat8**) tested under Tomcat 8
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5viaHNAPI_JDBC_Tomcat8**) tested under Tomcat 8

2. Hibernate OGM via Hibernate Native API, JTA environment, EJB/BMT (Bean Managed Transaction) 
   - For Hibernate OGM 4.0.0.Beta2 (app name: **HOGM4viaHNAPI_JTA_EJB_BMT_Payara4**) tested under Payara 4
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5viaHNAPI_JTA_EJB_BMT_Payara4**) tested under Payara 4
   
3. Hibernate OGM via Hibernate Native API, JTA environment, EJB/CMT (Container Managed Transaction)
   - For Hibernate OGM 4.0.0.Beta2 (app name: **HOGM4viaHNAPI_JTA_EJB_CMT_Payara4**) tested under Payara 4
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5viaHNAPI_JTA_EJB_CMT_Payara4**) tested under Payara 4

4. Hibernate OGM via Hibernate Native API, JTA environment, built-in JTA platform
   - For Hibernate OGM 4.0.0.Beta2 (app name: **HOGM4viaHNAPI_JTA_Payara4**) tested under Payara 4
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5viaHNAPI_JTA_Payara4**) tested under Payara 4
   
5. Hibernate OGM via Hibernate Native API, standalone JTA,  JBoss Transactions
   - For Hibernate OGM 4.0.0.Beta2 (app name: **HOGM4viaHNAPI_JTA_Tomcat8**) tested under Tomcat 8
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5viaHNAPI_JTA_Tomcat8**) tested under Tomcat 8

6. Hibernate OGM via Java Persistence API, JEE application under Payara 4
   - For Hibernate OGM 4.2.0.Final (app name: **HOGM4viaJPA_EE_Payara**) tested under Payara 4
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5viaJPA_EE_Payara**) tested under Payara 4
    
7. Hibernate OGM via Java Persistence API, RESOURCE_LOCAL under Tomcat
   - For Hibernate OGM 4.0.0.Beta2 (app name: **HOGM4viaJPA_RESOURCELOCAL_Tomcat8**) tested under Tomcat 8
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5viaJPA_RESOURCELOCAL_Tomcat8**) tested under Tomcat 8   
   
8. Hibernate OGM via Java Persistence API, Spring 4
   - For Hibernate OGM 4.0.0.Beta2 (app name: **HOGM4viaJPA_SPRINGMVC4**) tested under Payara 4
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5viaJPA_SPRINGMVC4**) tested under Payara 4
   
9. Hibernate OGM via Java Persistence API, standalone JTA,  JBoss Transactions
   - For Hibernate OGM 4.0.0.Beta2 (app name: **HOGM4viaJPAJTA_Tomcat8**) tested under Tomcat 8
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5viaJPAJTA_Tomcat8**) tested under Tomcat 8

10. Hibernate OGM 5.0 with MongoDB - using identifiers
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5_MongoDB_Id**) tested under Payara 4

11. Hibernate OGM 5.0 with MongoDB - using @OneToOne and @MapsId
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5_MongoDB_OTO_MapsId**) tested under Payara 4

12. Hibernate OGM 5.0 with MongoDB - bidirectional @OneToOne
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5_MongoDB_OTO**) tested under Payara 4
   
13. Hibernate OGM 5.0 with MongoDB - @OneToMany/@ManyToOne
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5_MongoDB_OTM**) tested under Payara 4

14. Hibernate OGM 5.0 with MongoDB - @ManyToMany
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5_MongoDB_MTM**) tested under Payara 4
   
15. Hibernate OGM 5.0 with MongoDB - @ElementCollection
   - For Hibernate OGM 5.0.1.Final (app name: **HOGM5_MONGODB_ElementCollection**) tested under Payara 4
