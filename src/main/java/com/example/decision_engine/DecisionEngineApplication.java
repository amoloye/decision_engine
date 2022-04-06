package com.example.decision_engine;

import com.example.decision_engine.entity.Segmentation;
import com.example.decision_engine.entity.UserDetails;
import com.example.decision_engine.repository.UserDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class DecisionEngineApplication implements CommandLineRunner {

    public static void main (String[] args) {
        SpringApplication.run(DecisionEngineApplication.class, args);
    }

    private final UserDetailsRepository userDetailsRepository;

    @Override
    public void run (String... args) {
        UserDetails  user1 = new UserDetails("49002010965", Segmentation.DEBT);
        UserDetails user2 = new UserDetails("49002010976",Segmentation.SEG_ONE);
        UserDetails user3 = new UserDetails("49002010987",Segmentation.SEG_TWO);
        UserDetails user4 = new UserDetails("49002010998",Segmentation.SEG_THREE);

        List<UserDetails> userDetailsList = List.of(user1,user2,user3,user4);

        userDetailsRepository.saveAll(userDetailsList);

    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/decision").allowedOrigins("http://localhost:8080");
            }
        };
    }
}
