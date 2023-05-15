package org.acme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record RegistrationDTO(
        @NotBlank
        @NotNull
        @Length(min = 3, max = 50)
        String name
) {
}
