package com.hana.bankai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import static io.lettuce.core.pubsub.PubSubOutput.Type.message;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BankaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankaiApplication.class, args);
    }

}
