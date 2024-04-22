package com.bookblend.bookblendbackend.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      //TODO: Proper authentication.
      http.csrf().disable().cors().disable();
      http.authorizeHttpRequests().anyRequest().permitAll();
      return http.build();
    }

}
