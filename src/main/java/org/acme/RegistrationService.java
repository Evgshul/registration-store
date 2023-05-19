package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Method to get list of RegistartionDTO.
     */
    public List<RegistrationDTO> getRegistrationList() {
        var registrationEntityList =
                em.createQuery("select r from RegistrationEntity r", RegistrationEntity.class).getResultList();
        return mapEntityToDto(registrationEntityList);
    }

    /**
     * Mapping RegistrationEntity to RegistrationDTO.
     * @param entityList list of RegistrationEntity
     * @return RegistrationDTO list
     */
    private List<RegistrationDTO> mapEntityToDto(final List<RegistrationEntity> entityList) {
        return entityList.stream()
                .map(o -> new RegistrationDTO(o.getName(), o.getSurname(), o.getEmail()))
                .collect(Collectors.toList());
    }
}
