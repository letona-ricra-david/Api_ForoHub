package com.david.api.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAuthenticacion(
        @NotBlank String email,
        @NotBlank String contrasenia
) {
}
