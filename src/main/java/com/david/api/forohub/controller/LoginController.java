package com.david.api.forohub.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.david.api.forohub.domain.usuario.DatosAuthenticacion;
import com.david.api.forohub.domain.usuario.Usuario;
import com.david.api.forohub.infra.security.DatosTokenJWT;
import com.david.api.forohub.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public  ResponseEntity login(@RequestBody @Valid DatosAuthenticacion datos ){
        var authenticacionToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.contrasenia());
        var autenticacion = authenticationManager.authenticate(authenticacionToken);
        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());

        return  ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }

}
