package com.hasitha.employeemanagment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*WebSecurityConfigurerAdapter class is depricated.
*So SecurityConfigUpdated class contains the latest alternative way of
* doing same configurations*/
/*@Configuration
@EnableWebSecurity
public class SecurityConfigLegacy extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hasithat")
                .password(passwordEncoder().encode("12345"))
                .roles("USER");

        auth.inMemoryAuthentication()
                .withUser("amanp")
                .password(passwordEncoder().encode("34567"))
                .roles("ADMIN");

        auth.inMemoryAuthentication()
                .withUser("oliver")
                .password(passwordEncoder().encode("56789"))
                .roles("ADMIN,USER");
    }

    //Enable traffic for nonSecure  url endpoint without doing any user authentication.
    //For url endpoints welcome and greeting authenticate the user
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/nonSecure").permitAll()
                .and()
                .authorizeRequests().antMatchers("/welcome","/greeting")
                .authenticated().and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}*/
