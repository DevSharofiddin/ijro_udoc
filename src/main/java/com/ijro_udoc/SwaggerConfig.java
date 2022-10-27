package com.ijro_udoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author shukurkhon
 * @since 11/08/22
 */
@Configuration
public class SwaggerConfig {

    @Value("${springdoc.swagger.servers}")
    private String swaggerServers;

    @Bean
    public OpenAPI customOpenAPI() {
        List<String> serverUrls = List.of(swaggerServers.split("\\|"));
        List<Server> servers = serverUrls.stream().map(
                i -> {
                    Server server = new Server();
                    server.setUrl(i);
                    return server;
                }
        ).collect(Collectors.toList());

        String moduleName = "Ijro_Udoc";
        final String apiTitle = String.format("%s API", StringUtils.capitalize(moduleName));
        String apiVersion = "3.0.0";
        return new OpenAPI()
                .info(new Info().title(apiTitle).version(apiVersion))
                .servers(servers);
    }
}
