package org.acme;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/registration")
public class RegistrationResource {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationResource.class);
    @Inject
    RegistrationService registrationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void register(@Valid @NotNull RegistrationDTO registration) {
        var name = registration.name();
        var surname = registration.surname();
        var email = registration.email();
        LOG.debug("registration for {} {}", name, surname);
        registrationService.register(name, surname, email);
    }
}
