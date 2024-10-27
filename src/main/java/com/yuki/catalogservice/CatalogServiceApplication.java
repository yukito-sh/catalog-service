package com.yuki.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogServiceApplication {

  // Application 시작하는 메소드, 현재 클래스를 Application Bootstrap step 실행하도록 설정한다.
  public static void main(String[] args) {
    SpringApplication.run(CatalogServiceApplication.class, args);
  }

}
