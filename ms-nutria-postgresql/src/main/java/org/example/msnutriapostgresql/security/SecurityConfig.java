package org.example.msnutriapostgresql.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .cors(c -> c.configurationSource(corsConfigurationSource()))
            .csrf(cs -> cs.disable())
            .authorizeHttpRequests(auth -> auth
                    // libera todos os preflights
                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    // regras reais
                    .requestMatchers("/admin/**").hasRole("NUTRIA_ADMIN")
                    .requestMatchers("/usuarios/**").hasAnyRole("NUTRIA_ADMIN", "NUTRIA")
                    .anyRequest().authenticated()
            )
            // basic auth já configura o entry point padrão (401) sem handler custom
            .httpBasic(Customizer.withDefaults());

    return http.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();

    // suas origens
    config.setAllowedOrigins(List.of(
            "http://localhost:5173",
            "https://area-restrita-krae.onrender.com"
    ));

    // permita o que o navegador pode pedir no preflight
    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
    config.addAllowedHeader(CorsConfiguration.ALL);
    config.setExposedHeaders(List.of("Authorization"));
    config.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    // importante: wildcard, não a barra "seca"
    source.registerCorsConfiguration("/admin/**", config);
    // se quiser cobrir mais caminhos, repita o register
    return source;
  }

  @Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
    UserDetails admin = User.withUsername("nutriaAdmin")
            .password(passwordEncoder.encode("nutriaAdmin123"))
            .roles("NUTRIA_ADMIN")
            .build();
    UserDetails user = User.withUsername("nutria")
            .password(passwordEncoder.encode("nutria123"))
            .roles("NUTRIA")
            .build();
    return new InMemoryUserDetailsManager(admin, user);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
