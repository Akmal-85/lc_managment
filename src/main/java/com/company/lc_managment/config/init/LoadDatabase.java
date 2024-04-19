package com.company.lc_managment.config.init;
import com.company.lc_managment.entity.Address;
import com.company.lc_managment.entity.User;
import com.company.lc_managment.enums.Gender;
import com.company.lc_managment.enums.Roles;
import com.company.lc_managment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class LoadDatabase {

    private final UserRepository userRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            User admin = User.builder()
                    .firstName("Akmal")
                    .lastName("Davlatov")
                    .gender(Gender.MALE)
                    .phoneNumber("+998930804064")
                    .password(new BCryptPasswordEncoder().encode("123"))
                    .role(Roles.ADMIN)
                    .email("akmmaldavlatov85@mail.ru")
                    .birthDay(LocalDate.of(1985,10,20))
                    .address(Address.builder().city("Xorazm").country("UZB").description("Hazorasp").build())
                    .username("admin")
                    .statusTech(false)
                    .build();
            if (userRepository.findByPhoneNumber("+9989390804064").isEmpty())
                userRepository.save(admin);
        };
    }
}
