package com.jibug.cetty.spring;

import com.jibug.cetty.spring.config.CettyConfig;
import com.jibug.cetty.spring.handler.KuaidailiPageHandler;
import com.jibug.cetty.spring.service.CettyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heyingcai
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CettyConfig.class);

        CettyService service = applicationContext.getBean(CettyService.class);

        KuaidailiPageHandler handler = applicationContext.getBean(KuaidailiPageHandler.class);

        service.start(handler);


    }

}
