package com.example;

public class BatchExecutor {

    protected String clazz;

    protected String jobId;

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return this.jobId;
    }
}
