package com.desafio.itau;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class ItauApplication {
    private static Logger log = LoggerFactory.getLogger(ItauApplication.class);

    public static void main(final String[] args) throws UnknownHostException {
        final SpringApplication app = new SpringApplication(ItauApplication.class);
        final ApplicationContext context = app.run(args);
        final Environment env = context.getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env
                        .getProperty("server.port"),
                protocol,
                InetAddress.getLocalHost()
                        .getHostAddress(),
                env.getProperty("server.port"),
                env.getActiveProfiles());

    }

}
