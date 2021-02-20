package com.homework.pr.ten03;


import io.kimmking.spring02.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import javax.annotation.PostConstruct;

/**
 * @author ohYoung
 * @date 2021/2/21 0:53
 */
public class App {

    @Autowired
    private School school;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void testSchool() {
        System.out.println(school);
    }

}
