package com.clement.fokuz.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(contact = @Contact(name = "fokuz"),
                description = "OpenAPI Documentation for Fokuz App",
                title = "Fokuz", version = "1.0.0")
)
@SecurityScheme(name = "bearerAuth", description = "JWT auth description",
        scheme = "bearer", type = SecuritySchemeType.HTTP, bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER)
@Configuration
public class OpenApiConfig {
}
