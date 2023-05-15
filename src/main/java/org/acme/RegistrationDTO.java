package org.acme;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * DTOs objects implementation.
 */
public record RegistrationDTO(
        @NotBlank
        @NotNull
        @Length(min = 3, max = 50)
        String name,

        @NotBlank
        @NotNull
        @Length(min = 3, max = 50)
        String surname,

        @NotBlank
        @NotNull
        @Email(regexp = EMAIL_REGEX)
        String email
) {
        private final static String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
}
