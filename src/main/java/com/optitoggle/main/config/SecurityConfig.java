package com.optitoggle.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.optitoggle.main.security.CustomUserDetailsService;
import com.optitoggle.main.security.JwtAuthenticationEntryPoint;
import com.optitoggle.main.security.JwtAuthenticationFilter;

@Configuration
@EnableWebMvc
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

        private static final String[] PUBLIC_URLS = { "/api/v1/auth/**", "/v3/api-docs", "/v2/api-docs",
                        "/swagger-resources/**", "/swagger-ui/**", "/webjars/**", "/optitoggle/toggle/{flagId}" };

        @Autowired
        private CustomUserDetailsService customUserDetailsService;

        @Autowired
        private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

        @Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(requests -> requests
                                                .antMatchers(PUBLIC_URLS)
                                                .permitAll()
                                                .anyRequest()
                                                .authenticated())
                                .csrf(AbstractHttpConfigurer::disable)
                                .exceptionHandling(exceptionHandling -> exceptionHandling
                                                .authenticationEntryPoint(this.jwtAuthenticationEntryPoint))
                                .sessionManagement(sessionManagement -> sessionManagement
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .addFilterBefore(this.jwtAuthenticationFilter,
                                                UsernamePasswordAuthenticationFilter.class)
                                .authenticationProvider(daoAuthenticationProvider());

                return http.build();

        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider daoAuthenticationProvider() {
                DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
                provider.setUserDetailsService(this.customUserDetailsService);
                provider.setPasswordEncoder(passwordEncoder());
                return provider;
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
                return configuration.getAuthenticationManager();
        }

        @Bean
        public FilterRegistrationBean corsFilter() {
                UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
                CorsConfiguration corsConfiguration = new CorsConfiguration();
                corsConfiguration.setAllowCredentials(true);
                corsConfiguration.addAllowedOriginPattern("*");
                corsConfiguration.addAllowedHeader("Authorization");
                corsConfiguration.addAllowedHeader("Content-Type");
                corsConfiguration.addAllowedHeader("Accept");
                corsConfiguration.addAllowedMethod("POST");
                corsConfiguration.addAllowedMethod("GET");
                corsConfiguration.addAllowedMethod("DELETE");
                corsConfiguration.addAllowedMethod("PUT");
                corsConfiguration.addAllowedMethod("OPTIONS");
                corsConfiguration.setMaxAge(3600L);

                urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
                FilterRegistrationBean bean = new FilterRegistrationBean<>(
                                new CorsFilter(urlBasedCorsConfigurationSource));
                return bean;
        }

}
