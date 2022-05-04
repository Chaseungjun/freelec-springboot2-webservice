package com.simple.asw;

//import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AswApplication {

    public static void main(String[] args) {
        SpringApplication.run(AswApplication.class, args);
    }


//    @Bean
//    public ModelMapper ModelMapper(){
//        return new ModelMapper();
//    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();


    }
}
