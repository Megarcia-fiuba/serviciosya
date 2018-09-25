package com.capgemini.serviciosya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application {



    public Application () {

        super ();
    }


    public static void main (String[] args) {

        SpringApplication.run (Application.class);
    }
}
