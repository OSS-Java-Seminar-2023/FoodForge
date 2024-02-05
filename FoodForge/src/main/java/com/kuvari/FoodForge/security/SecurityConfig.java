package com.kuvari.FoodForge.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .formLogin(form -> form.loginPage("/login")
                        .loginProcessingUrl("/login")
                        .successHandler(myAuthenticationSuccessHandler()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/hello/**").hasAuthority("USER")
                                .requestMatchers("/users/**").hasAuthority("ADMIN")
                                .requestMatchers("/register/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/register").permitAll())
                .logout()
                .logoutSuccessUrl("/login");




        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
        }



}


