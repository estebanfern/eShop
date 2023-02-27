package com.mishop.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class SecurityConfig{


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()

        .authorizeHttpRequests()
            .requestMatchers("/", "/home", "/index", "/registro", "**css/**","**js/**","**img/**","/foto-comentario").permitAll()
            .requestMatchers( "/registro", "/verificacion", "/login",
                            "/css/**","/js/**","/img/**").permitAll()
            .requestMatchers("/productos").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .usernameParameter("username")
            .passwordParameter("password")
            .loginPage("/login")
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


    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //         .csrf().disable()
    //         .authorizeHttpRequests(authorize -> authorize
    //                 .requestMatchers("/").permitAll()
    //                 .requestMatchers("/login").permitAll()
    //                 //.requestMatchers(HttpMethod.GET, "/api/producto/list").permitAll()
    //                 //.requestMatchers(HttpMethod.GET, "/api/producto/{id}").permitAll()
    //                 //.requestMatchers(HttpMethod.POST, "/api/producto/save").permitAll()
    //                 //.requestMatchers(HttpMethod.DELETE, "/api/producto/delete/{id}").permitAll()
    //                 //.requestMatchers(HttpMethod.GET, "/productos").hasRole("ADMIN")
    //                 .anyRequest().authenticated() // any other request must be authenticated
    //                 )
    //         .formLogin(loginPanel -> loginPanel.loginPage("/login").permitAll())
    //                 //.logout(logout -> logout.logoutUrl("/logout").permitAll())
    //         .httpBasic();
    //     return http.build();
    // }
    

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


