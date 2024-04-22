package com.student.register.StudentRegister.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class StudentConfiguration
{
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        return  new JdbcUserDetailsManager(dataSource);
    }

    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception
    {
        httpSecurity.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/admins/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                ).formLogin(form ->
                        form.loginPage("/showLoginForm")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                )
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied")
                );
        return httpSecurity.build();
    }*/

}
