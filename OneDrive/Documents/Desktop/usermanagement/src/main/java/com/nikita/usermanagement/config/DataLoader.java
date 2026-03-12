package com.nikita.usermanagement.config;

import com.nikita.usermanagement.entity.Role;
import com.nikita.usermanagement.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(RoleRepository roleRepository){

        return args -> {

            roleRepository.save(new Role(null,"ADMIN"));
            roleRepository.save(new Role(null,"MANAGER"));
            roleRepository.save(new Role(null,"USER"));

        };
    }
}