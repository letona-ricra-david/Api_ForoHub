package com.david.api.forohub.domain.usuario;

public record DatosActualizarUsuario(
          String nombre,
          String contrasenia,
          Perfil perfil
) {
}
