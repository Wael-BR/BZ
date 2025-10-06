package tn.bz.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class GlobalCorsConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CorsFilter corsFilter() {
        CorsConfiguration cfg = new CorsConfiguration();

        // If you use cookies/Authorization: specify the front-end origin explicitly.
        cfg.setAllowedOrigins(List.of("http://localhost:4200"));
        // If you truly need “any origin” with credentials, use patterns instead:
        // cfg.setAllowedOriginPatterns(List.of("*"));

        cfg.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS","PATCH"));
        cfg.setAllowedHeaders(List.of("*")); // includes Authorization, Content-Type, etc.
        cfg.setAllowCredentials(true);
        cfg.setMaxAge(3600L); // cache preflight for 1 hour

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Apply to everything so it catches /api/* and /generate/pom alike
        source.registerCorsConfiguration("/**", cfg);

        return new CorsFilter(source);
    }
}

