package com.cpan228.clotheswarehouse.config;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cpan228.clotheswarehouse.model.User;
import com.cpan228.clotheswarehouse.repository.UserRepository;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService(UserRepository userRepository) {
    return username -> {
      User user = userRepository.findByUsername(username);
      if (user != null) {
        return user;
      }

      throw new UsernameNotFoundException(username);
    };
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests()
        .requestMatchers(toH2Console()).permitAll()
        .requestMatchers("/list")
        .hasRole("USER")
        .anyRequest().permitAll()

        .and()
        .formLogin()
        .loginPage("/login")

        .defaultSuccessUrl("/list", true)
        .and()
        .logout()
        .logoutSuccessUrl("/")

        .and()
        .headers()
        .frameOptions();

    http.csrf().disable();
    return http.build();

  }
}
