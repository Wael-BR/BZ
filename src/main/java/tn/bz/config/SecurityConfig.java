package tn.bz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.*;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())     // enable CORS at security layer
                .csrf(csrf -> csrf.disable())        // disable CSRF for APIs (dev)
                .authorizeHttpRequests(auth -> auth
                        // allow your API endpoints without auth:
                        .requestMatchers(
                                "/api/classes",
                                "/api/generate-json",
                                "/generate/**",
                                "/api/json-upload/**",
                                "/api/dynamic/**",
                                "/api/generic-convert/**"
                        ).permitAll()
                        .anyRequest().permitAll()        // or .authenticated() if you need it elsewhere
                )
                .formLogin(form -> form.disable())   // avoid redirect to /login
                .httpBasic(basic -> basic.disable()) // optional in dev
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cfg = new CorsConfiguration();
        // if you need cookies, keep allowCredentials=true and use explicit origins (no "*")
        cfg.setAllowedOrigins(List.of("http://localhost:4200"));
        cfg.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        cfg.setAllowedHeaders(List.of("*"));
        cfg.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
}
