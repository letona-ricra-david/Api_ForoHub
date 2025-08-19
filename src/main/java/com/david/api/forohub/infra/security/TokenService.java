package com.david.api.forohub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.david.api.forohub.domain.usuario.Usuario;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private  String secret;
    private static final String EMISOR_TOKEN = "Foro-Hub API David";
    public  String generarToken(Usuario usuario){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return   JWT.create()
                    .withIssuer(EMISOR_TOKEN)
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(obtenerFechaExpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException e){
            throw new RuntimeException("Error generando JWT para el usuario: " + usuario.getEmail(), e);
        }


    }

    private Instant obtenerFechaExpiracion() {
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-05:00"));
    }

    public String getSubject(String token) {
        if(token == null || token.isEmpty()){
            System.out.println("No hay token .....");
            throw new RuntimeException("No existe token en la peticion");
        }
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return  JWT.require(algoritmo)
                    .withIssuer(EMISOR_TOKEN)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e){
            throw new RuntimeException("Token inválido o expirado: "+ token, e);
        }
    }
}
