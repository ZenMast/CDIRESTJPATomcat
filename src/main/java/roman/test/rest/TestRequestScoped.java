package roman.test.rest;


import java.time.LocalDateTime;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;


@RequestScoped
public class TestRequestScoped {

    @Inject
    private EntityManager em;

    public String testService() {
        TestEntity testEntity = new TestEntity();
        String name = "test" + LocalDateTime.now();
        testEntity.setName(name);

        em.persist(testEntity);

        return "test successful if not null & true: " + em.find(TestEntity.class, 1);
    }
}
