package com.abhishek.SecurityProject.config;

import com.abhishek.SecurityProject.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //disabling csrf token
        http.csrf(customizer->customizer.disable());
        http.authorizeHttpRequests(request->request.anyRequest().authenticated());

        //for default spring security settings in browser
//        http.formLogin(Customizer.withDefaults());

        //for default spring security settings in postman
        http.httpBasic(Customizer.withDefaults());

        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1= User.withDefaultPasswordEncoder()
//                .username("Abhishek")
//                .password("123")
//                .roles("ADMIN").build();
//
//        UserDetails user2=User.withDefaultPasswordEncoder()
//                .username("Ayush")
//                .password("1234")
//                .roles("USER").build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        return authenticationProvider;
    }
}
