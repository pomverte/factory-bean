package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    @Bean
    public BatchExecutorFactory batchExecutorFactory() {
        BatchExecutorFactory batchExecutorFactory = new BatchExecutorFactory();
        batchExecutorFactory.setSingleton(false);
        return batchExecutorFactory;
    }

    @Bean
    @SuppressWarnings("unchecked")
    public BatchExecutor batchExecutor1(BatchExecutorFactory batchExecutorFactory,
            @Value("${batch.exe1.class.name:com.example.BatchExecutorDefault}") String className,
            @Value("${batch.exe1.job.id}") String jobId) throws Exception {

        // factory configuration
        batchExecutorFactory.setImplementationClass((Class<? extends BatchExecutor>) Class.forName(className));

        // set bean values
        Map<String, Object> beanProperties = new HashMap<String, Object>();
        beanProperties.put("jobId", jobId);
        batchExecutorFactory.setBeanProperties(beanProperties);

        // create new bean
        return batchExecutorFactory.getObject();
    }

    @Bean
    @SuppressWarnings("unchecked")
    public BatchExecutor batchExecutor2(BatchExecutorFactory batchExecutorFactory,
            @Value("${batch.exe2.class.name:com.example.BatchExecutorDefault}") String className,
            @Value("${batch.exe2.job.id}") String jobId, @Value("${batch.exe2.code.name}") String codeName)
                    throws Exception {

        // factory configuration
        batchExecutorFactory.setImplementationClass((Class<? extends BatchExecutor>) Class.forName(className));

        // set bean values
        Map<String, Object> beanProperties = new HashMap<String, Object>();
        beanProperties.put("jobId", jobId);
        beanProperties.put("codeName", codeName);
        batchExecutorFactory.setBeanProperties(beanProperties);

        // create new bean
        return batchExecutorFactory.getObject();
    }

}
