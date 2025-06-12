package org.fathos82.notionapi.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    @PostConstruct
    public void loadEnv() {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("BD_URL", dotenv.get("BD_URL"));
        System.setProperty("BD_URL", dotenv.get("BD_USERNAME"));
        System.setProperty("BD_URL", dotenv.get("BD_PASSWORD"));

    }
}
