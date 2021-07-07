package com.joshua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication
//@ComponentScan("com.joshua.domain.boards")

@EnableJpaAuditing //Auditing을 하기위해서는 써야함
@SpringBootApplication(scanBasePackages ="com.joshua")
//@Configuration
//@EnableAutoConfiguration

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
