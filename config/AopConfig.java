package com.example.library.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopConfig {

    @Before("execution(* com.example.library.service.*.*(..))")
    public void beforeServiceMethod() {
        // Logging or other cross-cutting concerns
        System.out.println("A service method is about to be called.");
    }
}
