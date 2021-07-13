package com.droar.kafkaex.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableCircuitBreaker
@SpringBootApplication
public class KafkaExApp {

  public static void main(String[] args) {
    SpringApplication.run(KafkaExApp.class, args);
  }
}
