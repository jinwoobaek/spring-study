package com.jinwoo.springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//Lang : Java 8 (OpenJDK)
//DB : H2(for test)
//ORM : JPA
//Back-End : Spring Boot (ver. 2.3.1)
//Templete : Bootstrap, Mustache
//Build : Maven
//작성자 : Jinwoo


@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class SpringStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStudyApplication.class, args);
    }

}
