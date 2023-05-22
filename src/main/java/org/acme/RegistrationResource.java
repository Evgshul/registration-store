package org.acme;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/registration")
public class RegistrationResource {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationResource.class);
    @Inject
    RegistrationService registrationService;

    @Inject
    Mailer mailer;

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

    /**
     * Provide list of all Registrations.
     *
     * @return RegistrationDto list
     */
    @GET
    public List<RegistrationDTO> getRegistrationList() {
        return registrationService.getRegistrationList();
    }

    /**
     * Email sender
     * @param email mail recipient address
     * @return notification of mail sent success
     */
    @GET
    @Path("/{email}")
    public String sendEmail(@PathParam("email") final String email) {
        mailer.send(
                Mail.withText(email,
                        "Registration info",
                        "Your registration is approved."
                )
        );

        registrationService.approveEntity(email);
        LOG.debug("Registration for {} approved", email);
        return "Email sent successfully";
    }
}
