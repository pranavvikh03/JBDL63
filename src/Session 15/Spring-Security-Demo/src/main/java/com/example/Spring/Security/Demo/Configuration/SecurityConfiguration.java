package com.example.Spring.Security.Demo.Configuration;

import com.example.Spring.Security.Demo.Service.UserInfoDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration{

    //Authentication
    @Bean
    public UserDetailsService getUserDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails admin = UserData.withUsername("Pranav")
//                .password(passwordEncoder.encode("Admin"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = UserData.withUsername("Shaban")
//                .password(passwordEncoder.encode("NormalUser"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
        return new UserInfoDetailsService();
    }

    //Password Encoder
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Authorization
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(
//                        auth ->
//                                auth.requestMatchers("/users/allowedToAll").permitAll()
//                                        .requestMatchers("/users/allowedToAdmin").hasRole("ADMIN")
//                                        .requestMatchers("/users/allowedToUser").hasRole("USER")
//                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
