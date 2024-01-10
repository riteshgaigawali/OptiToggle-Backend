// package com.optitoggle.main.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

// @Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

// http.csrf(csrf -> csrf.disable())
// .authorizeHttpRequests((authorize) ->
// authorize.requestMatchers("/**").permitAll().anyRequest()
// .authenticated())
// .httpBasic(httpSecurityHttpBasicConfigurer -> {
// httpSecurityHttpBasicConfigurer.authenticationEntryPoint(basicAuthEntryPoint);
// });

// }

// }
