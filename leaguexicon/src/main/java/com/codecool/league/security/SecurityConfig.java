package com.codecool.league.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenServices jwtTokenServices;

    public SecurityConfig(JwtTokenServices jwtTokenServices) {
        this.jwtTokenServices = jwtTokenServices;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .authorizeRequests()

                .antMatchers(HttpMethod.GET,"/lxn/champions").permitAll()
                .antMatchers(HttpMethod.GET,"/lxn/champions/**").permitAll()
                .antMatchers(HttpMethod.GET,"/lxn/news/{pageNumber}").permitAll()
                .antMatchers(HttpMethod.GET,"/lxn/riot/**").permitAll()
                .antMatchers(HttpMethod.POST,"/lxn/auth/login").permitAll()
                .antMatchers(HttpMethod.POST,"/lxn/auth/register").permitAll()

                .antMatchers(HttpMethod.GET,"/lxn/user/**").authenticated()
                .antMatchers(HttpMethod.PUT,"/lxn/user/update-favourite").authenticated()

                .anyRequest().denyAll()
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenServices), UsernamePasswordAuthenticationFilter.class) ; // anything else is denied
    }
}
