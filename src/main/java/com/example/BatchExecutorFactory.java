package com.example;

import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * http://stackoverflow.com/a/6598351
 * 
 * http://howtodoinjava.com/2015/01/23/how-to-create-beans-using-spring-factorybean/
 * 
 * @author Hong Viet
 *
 */
public class BatchExecutorFactory extends AbstractFactoryBean<BatchExecutor> {

    private Class<? extends BatchExecutor> implementationClass;

    private Map<String, Object> beanProperties;

    @Override
    public Class<? extends BatchExecutor> getObjectType() {
        return this.implementationClass;
    }

    @Override
    protected BatchExecutor createInstance() throws Exception {
        final BatchExecutor instance = this.implementationClass.newInstance();
        if (this.beanProperties != null && !this.beanProperties.isEmpty()) {
            final BeanWrapper wrapper = new BeanWrapperImpl(instance);
            wrapper.setPropertyValues(this.beanProperties);
        }
        return instance;
    }

    public void setBeanProperties(final Map<String, Object> beanProperties) {
        this.beanProperties = beanProperties;
    }

    public void setImplementationClass(final Class<? extends BatchExecutor> implementationClass) {
        this.implementationClass = implementationClass;
    }

}
