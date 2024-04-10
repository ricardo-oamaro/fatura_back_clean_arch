package br.com.fatura.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FaturaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaturaApplication.class, args);
    }
}