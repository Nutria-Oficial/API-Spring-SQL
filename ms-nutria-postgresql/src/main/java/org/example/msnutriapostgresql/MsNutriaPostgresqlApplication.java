package org.example.msnutriapostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {
        ReactiveSecurityAutoConfiguration.class,
        ReactiveUserDetailsServiceAutoConfiguration.class
})
public class MsNutriaPostgresqlApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsNutriaPostgresqlApplication.class, args);
  }
}