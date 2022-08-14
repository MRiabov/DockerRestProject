package edu.mriabov.restproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients(basePackages = "edu.mriabov.restproject.config")
public class RestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestProjectApplication.class, args);
    }

}
