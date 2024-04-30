package com.bookblend.bookblendbackend.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// configuration o fthe security enpoints
@Configuration
public class WebSecurityConfig {

  // we create a security filter chain bean  
  // it creates the security filter chain that will be used to secure the endpoints
  // makes sure request to the api are valid before puttin it through the controller
  // the secuirty filter chain replaces the defult spring security filter chain that Spring Boot auto-configures
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //TODO: Proper authentication.
    // csrf is a method for verfiying the origin of the request
    http.csrf().disable().cors().disable();
    http.authorizeHttpRequests().anyRequest().permitAll();
    return http.build();
  }

}
