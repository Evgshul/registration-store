package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * Implementation of service registration.
 */
@ApplicationScoped
public class RegistrationService {
    @PersistenceContext
    EntityManager em;

    /**
     * New object registration method.
     */
    @Transactional
    public void register(final String name,
                         final String surname,
                         final String email) {
        var reg = new RegistrationEntity();
        reg.setName(name);
        reg.setSurname(surname);
        reg.setEmail(email);
        em.persist(reg);
    }
}
