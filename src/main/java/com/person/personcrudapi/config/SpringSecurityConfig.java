package com.person.personcrudapi.config;

import io.swagger.models.HttpMethod;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private String admin = "ADMIN";
    private String uri = "/api/v1/persons/**";
    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", admin);

    }

    // Secure the endpoints with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(String.valueOf(HttpMethod.GET), uri).hasRole("USER")
                .antMatchers(String.valueOf(HttpMethod.POST), "/api/v1/persons").hasRole(admin)
                .antMatchers(String.valueOf(HttpMethod.PUT), uri).hasRole(admin)
                .antMatchers(String.valueOf(HttpMethod.PATCH), uri).hasRole(admin)
                .antMatchers(String.valueOf(HttpMethod.DELETE), uri).hasRole(admin)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}