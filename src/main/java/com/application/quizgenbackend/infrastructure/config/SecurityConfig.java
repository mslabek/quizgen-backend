package com.application.quizgenbackend.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize.antMatchers("/swagger-ui.html")
                                                         .permitAll()
                                                         .antMatchers("/swagger-ui/**")
                                                         .permitAll()
                                                         .antMatchers("/v3/api-docs/**")
                                                         .permitAll()
                                                         .antMatchers("/**")
                                                         .permitAll())
            .cors()
            .and()
            .headers()
            .frameOptions()
            .disable()
            .and()
            .csrf()
            .disable();
    }
}
