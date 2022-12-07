package com.london.tour.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * created by Diluni
 * on 12/7/2022
 */
@Component
public class ContextUtil implements ApplicationContextAware {

    /**
     * This class contains generic implementation for inject beans in unidentified components
     * of springboot application
     */

    private static ApplicationContext applicationContext;

    public ContextUtil() {
    }

    public void setApplicationContext(ApplicationContext app) throws BeansException {
        applicationContext = app;
    }

    public static <T> T getBean(Class<T> t) {
        return applicationContext.getBean(t);
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> t) {
        return applicationContext.getBean(name, t);
    }

}
