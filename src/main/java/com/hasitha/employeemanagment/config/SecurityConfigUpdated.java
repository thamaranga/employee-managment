package com.hasitha.employeemanagment.config;

import com.hasitha.employeemanagment.service.EmployeeUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
/*Enable method level security for Roles*/
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigUpdated {

    /*This password encorder will encrypt/decrypt passwords for us*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*This method fetches the user details from the db*/
    @Bean
    public UserDetailsService userDetailsService() {
        /*UserDetails user1= User.withUsername("hasithat").
                password(passwordEncoder().encode("12345"))
                .roles("EMPLOYEE")
                .build();

        UserDetails user2= User.withUsername("kamal").
                password(passwordEncoder().encode("34567"))
                .roles("MANAGER")
                .build();

        UserDetails user3= User.withUsername("sahan").
                password(passwordEncoder().encode("6789"))
                .roles("HR")
                .build();

        UserDetails user4= User.withUsername("kumudu").
                password(passwordEncoder().encode("4444"))
                .roles("MANAGER", "HR")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3, user4);*/

        return new EmployeeUserDetailsService();

    }

    /*Enable traffic for /employee/welcome , /employee/create url endpoint without doing any user authentication.
    For all other url endpoints which starts with /employee  authenticate the user */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Below part is related to SecurityDemoController endpoints
        /*return http.authorizeRequests().
                antMatchers("/nonSecure").permitAll()
                .and()
                .authorizeRequests().antMatchers("/welcome","/greeting")
                .authenticated().and().
                httpBasic().and().build();*/

        return http.csrf().disable().authorizeRequests().antMatchers("/employee/welcome", "/employee/create").permitAll().and().authorizeRequests().antMatchers("/employee/*").authenticated().and().httpBasic().and().build();
    }
}
