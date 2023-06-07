package com.example.securityjpa4.demo.securityjpa4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class FooBarConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    MyUserDetailsService service;


    //this is for authentication purpose
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(service);
    }

    //this is for autherization purpose
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("admin")
                .antMatchers("/student/**").hasAnyAuthority("student","admin")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();

    }

    /*@Bean
    public PasswordEncoder getPassword(){

        return NoOpPasswordEncoder.getInstance();
    }*/

    /*@Bean
    public PasswordEncoder getPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }*/

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Bean
    public PasswordEncoder getMyPasswordEncoder(){
        return myPasswordEncoder;
    }


}
