package cs489.project.carrental.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@OpenAPIDefinition
public class OpenApiConfiguration {
    @Bean
    public OpenAPI setupOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Car Rental Mgmt API")
                                .description("Car Rental Managment API")
                                .version("1.0")
                )
//                .addServersItem(new Server().url("http://localhost:8080"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)

                        ))
                .security(Collections.singletonList(new SecurityRequirement().addList("bearerAuth")));


    }
}
