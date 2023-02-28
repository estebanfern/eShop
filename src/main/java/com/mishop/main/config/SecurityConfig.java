package com.mishop.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeHttpRequests()//.anyRequest().permitAll();
            .requestMatchers ("/home", "/index", "/registro", "**css/**","**js/**", "/api/usuario/new/").permitAll()
            .requestMatchers( "/registro", "/verificacion", "/login",
                            "/css/**","/js/**","/img/**").permitAll()
            .requestMatchers("/productos").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .defaultSuccessUrl("/inicio", true)
                .permitAll();


        return http.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //         .username("user")
    //         .password("password")
    //         .roles("ADMIN")
    //         .build();
    //     return new InMemoryUserDetailsManager(user);
    // }
    

    @Bean
    UserDetailsService userDetailsService() {
	    return new UserInfoUserDetailsService();
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


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}


