package com.mishop.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .requestMatchers(HttpMethod.GET).permitAll()
            .and()
            .httpBasic();
        return http.build();
    }
    

    @Bean
    UserDetailsManager users(DataSource dataSource, PasswordEncoder encoder) {
	JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
	return users;
    }

    // @Bean
    // UserDetailsManager createUsers(DataSource dataSource, PasswordEncoder encoder) {
	// UserDetails admin = User.builder()
	// 	.username("usuario")
	// 	.password(encoder.encode("usuario"))
	// 	.roles("USER")
	// 	.build();
	// JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
	// users.createUser(admin);
	// return users;
    // }

    //password encoder

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}


