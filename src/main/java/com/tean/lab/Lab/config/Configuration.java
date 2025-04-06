package com.tean.lab.Lab.config;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    String sstring(){
        return "string1";
    }

    @Bean
    String string2(String string){
        System.out.println(string);
        return string+"string2";
    }
}
