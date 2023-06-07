package com.example.securityjpa4.demo.securityjpa4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MyPasswordEncoder extends BCryptPasswordEncoder {

    @Bean
    public MyPasswordEncoder getEncoder(){
        return this;
    }
}
