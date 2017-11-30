package roman.test.rest;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.extern.slf4j.Slf4j;


/**
 * Class responsible for the creation of an EntityManagerFactory and EntityManagers
 * The factory is application scoped, meaning it is only produced once, after the start of the
 * application. The EntityManager is produced and closed on every separate request.
 */
//@Slf4j
public class EntityManagerProducer {
    @Inject
    private EntityManagerFactory entityManagerFactory;

    @Produces
    @ApplicationScoped
    public EntityManagerFactory createEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-pu-local");
//        log.debug("{} Entity manager factory was created", emf);
        return emf;
    }

    public void close(@Disposes EntityManagerFactory emf) {
        emf.close();
//        log.debug("{} Entity manager factory was closed", emf);
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        EntityManager em = this.entityManagerFactory.createEntityManager();
//        log.debug("{} Entity manager was created", em);
        return em;
    }

    public void closeEntityManager(@Disposes EntityManager em) {
        em.close();
//        log.debug("{} Entity manager was closed", em);
    }
}
