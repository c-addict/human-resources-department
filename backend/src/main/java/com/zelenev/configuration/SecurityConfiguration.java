package com.zelenev.configuration;

import com.zelenev.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtFilter filter;

    public SecurityConfiguration(JwtFilter filter) {
        this.filter = filter;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(GET, "/data/*").hasRole("USER")
                .antMatchers(POST, "/data/*").hasRole("USER")
                .antMatchers(PUT, "/data/*").hasRole("USER")
                .antMatchers(PATCH, "/data/*").hasRole("USER")
                .antMatchers(GET, "/work/*").hasRole("USER")
                .antMatchers(POST, "/work/*").hasRole("USER")
                .antMatchers(PUT, "/work/*").hasRole("USER")
                .antMatchers(PATCH, "/work/*").hasRole("USER")
                .antMatchers(POST, "/login").anonymous()
                .antMatchers(POST, "/registration").anonymous()
                .and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
