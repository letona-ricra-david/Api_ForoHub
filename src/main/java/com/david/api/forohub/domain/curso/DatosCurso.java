package com.david.api.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
        @NotBlank  String nombreCurso,
        @NotBlank  String categoriaCurso
) {
}
