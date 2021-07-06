package com.joshua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//@ComponentScan("com.joshua.domain.boards")

@SpringBootApplication(scanBasePackages ="com.joshua")
//@Configuration
//@EnableAutoConfiguration

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
