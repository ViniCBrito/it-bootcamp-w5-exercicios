package br.com.meli.romanosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RomanosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RomanosApiApplication.class, args);
    }
}
