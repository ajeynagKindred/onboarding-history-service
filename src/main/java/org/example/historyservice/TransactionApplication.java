package org.example.historyservice;//package org.example.walletservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;


@SpringBootApplication
@EnableRetry
public class TransactionApplication {
    public static void main(String[] args) {

        SpringApplication.run(TransactionApplication.class);
    }
}