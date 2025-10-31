package org.example.msnutriapostgresql.security;

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
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(
                    auth ->
                            auth.requestMatchers("/admin/login")
                                    .permitAll()
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