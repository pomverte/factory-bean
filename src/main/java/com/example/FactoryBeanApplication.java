package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FactoryBeanApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(FactoryBeanApplication.class, args);

        BatchExecutorDefault batchExecutor1 = (BatchExecutorDefault) context.getBean("batchExecutor1");
        System.out.println(batchExecutor1.getJobId());

        BatchExecutorSpecific batchExecutor2 = (BatchExecutorSpecific) context.getBean("batchExecutor2");
        System.out.println(batchExecutor2.getJobId());
        System.out.println(batchExecutor2.getCodeName());

    }
}
