package com.david.api.forohub.infra.springdocs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("jwt-foro-hub",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Foro-Hub API REST")
                        .version("1.0.0")
                        .description("API REST para la gestión de foros de discusión Foro-Hub, que permite registrar, listar, actualizar y eliminar tópicos y respuestas.")
                        .contact(new Contact()
                                .name("David Letona - Estudiante de Alura")
                                .email("letonaricradavid@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://foro-hub/api/licencia")));
    }

}

