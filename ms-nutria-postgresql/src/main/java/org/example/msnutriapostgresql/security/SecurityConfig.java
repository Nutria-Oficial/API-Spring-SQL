package org.example.msnutriapostgresql.security;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
  private final CustomAccessDeniedHandler customAccessDeniedHandler;

  public SecurityConfig(CustomAccessDeniedHandler customAccessDeniedHandler) {
    this.customAccessDeniedHandler = customAccessDeniedHandler;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        // 🔹 Ativa CORS e vincula a configuração personalizada
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            authorize ->
                authorize
                    .requestMatchers("/admin/**")
                    .hasRole("NUTRIA_ADMIN")
                    .requestMatchers("/usuarios/**")
                    .hasAnyRole("NUTRIA_ADMIN", "NUTRIA")
                    .anyRequest()
                    .authenticated())
        .httpBasic(Customizer.withDefaults())
        .exceptionHandling(exception -> exception.accessDeniedHandler(customAccessDeniedHandler));

    return http.build();
  }

  // cors apenas para admin para usar no navegador
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();

    config.setAllowedOrigins(
        List.of("http://localhost:5173", "https://area-restrita-krae.onrender.com/"));

    config.setAllowedMethods(List.of("GET"));
    config.setAllowedHeaders(List.of("Authorization", "Content-Type", "Accept"));
    config.setExposedHeaders(List.of("Authorization"));
    config.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    source.registerCorsConfiguration("/admin/**", config);

    return source;
  }

  @Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
    UserDetails admin =
        User.withUsername("nutriaAdmin")
            .password(passwordEncoder.encode("nutriaAdmin123"))
            .roles("NUTRIA_ADMIN")
            .build();
    UserDetails user =
        User.withUsername("nutria")
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
