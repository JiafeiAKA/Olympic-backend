package com.camt.olympic.security;

import com.camt.olympic.entity.Country;
import com.camt.olympic.entity.OlympicYear;
import com.camt.olympic.repositories.AthleteRepository;
import com.camt.olympic.repositories.CountryRepository;
import com.camt.olympic.repositories.OlympicYearRepository;
import com.camt.olympic.security.user.UserRepository;
import com.camt.olympic.security.user.Users;
import com.camt.olympic.security.user.token.AuthService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    @Autowired
    private AuthService authService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private OlympicYearRepository olympicYearRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private CountryRepository countryRepository;



    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder(); // สำหรับเข้ารหัสรหัสผ่าน
    }

    @Bean
    public CommandLineRunner insertAdminUser() {
        return args -> {
            // เช็คว่ามี admin อยู่แล้วหรือไม่
            if (userRepository.getUser("admin").isEmpty()) {
                // เพิ่มผู้ใช้ admin
                Users admin = new Users();
                admin.setUsername("admin");
                String passHash = authService.encodePassword("admin");
                admin.setPasswordHash(passHash); // เข้ารหัสรหัสผ่าน
                admin.setEmail("admin@mail.com");
                admin.setRole(Users.Role.ADMIN);
                admin.setCreatedAt(LocalDateTime.now());

                userRepository.save(admin);
                System.out.println("Admin user created.");
            } else {
                System.out.println("Admin user already exists.");
            }
        };
    }


    @PostConstruct
    public void loadJsonOlympic() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:olympic_year.json");
        String json = new String(Files.readAllBytes(Paths.get(resource.getURI())));



        ObjectMapper mapper = new ObjectMapper();
        List<OlympicYear> olympicYears = mapper.readValue(json, new TypeReference<List<OlympicYear>>() {});

        // บันทึกข้อมูลในฐานข้อมูล
        olympicYearRepository.saveAll(olympicYears);

    }



    @PostConstruct
    public void loadJson() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:country.json");
        String json = new String(Files.readAllBytes(Paths.get(resource.getURI())));



        ObjectMapper mapper = new ObjectMapper();
        List<Country> country = mapper.readValue(json, new TypeReference<List<Country>>() {});

        // บันทึกข้อมูลในฐานข้อมูล
        countryRepository.saveAll(country);

    }


//    @Bean
//    public CommandLineRunner insertSummarizedOlympicData()  {
//        return args -> {


//            List<Object[]> results =     athleteRepository.findOlympicYearSummarizedData();
//            List<OlympicYear> olympicYears = results.stream()
//                    .map(result -> new OlympicYear(
//                            (int) result[0], // year
//                            (String) result[1], // sport
//                            ((BigDecimal) result[2]).intValue(), // male
//                            ((BigDecimal) result[3]).intValue(), // female
//                            ((BigDecimal) result[4]).intValue(), // gold
//                            ((BigDecimal) result[5]).intValue(), // silver
//                            ((BigDecimal) result[6]).intValue(), // bronze
//                            ((BigDecimal) result[7]).intValue(), // maleGold
//                            ((BigDecimal) result[8]).intValue(), // maleSilver
//                            ((BigDecimal) result[9]).intValue(), // maleBronze
//                            ((BigDecimal) result[10]).intValue(), // femaleGold
//                            ((BigDecimal) result[11]).intValue(), // femaleSilver
//                            ((BigDecimal) result[12]).intValue(), // femaleBronze
//                            (String) result[13], // team
//                            (String) result[14], // noc
//                            (String) result[15], // games
//                            (String) result[16], // season
//                            (String) result[17], // city
//                            (String) result[18], // event
//                            ((BigDecimal) result[19]).intValue() // totalMedals
//                    ))
//                    .collect(Collectors.toList());
//
//              olympicYearRepository.saveAll(olympicYears);


//        };
//    }
}