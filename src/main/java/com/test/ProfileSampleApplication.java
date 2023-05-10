package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProfileSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileSampleApplication.class, args);
    }

    @Value("${application.message}")
    private String message;

    @Component
    @Profile(value = "dev")
    class RunnerOne implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            System.out.println(message);
        }
    }

    @Component
    @Profile(value = "prod")
    class RunnerTwo implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            System.out.println(message);
        }
    }
}
