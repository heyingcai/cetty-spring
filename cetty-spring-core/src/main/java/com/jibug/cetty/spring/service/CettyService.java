package com.jibug.cetty.spring.service;

import com.jibug.cetty.core.Bootstrap;
import com.jibug.cetty.core.Payload;
import com.jibug.cetty.core.handler.ConsoleReduceHandler;
import com.jibug.cetty.spring.handler.KuaidailiPageHandler;
import org.springframework.stereotype.Component;

/**
 * @author heyingcai
 */
@Component
public class CettyService {

    public void start(KuaidailiPageHandler kuaidailiPageHandler) {
        Bootstrap.me().
                startUrl("https://www.kuaidaili.com/free").
                addHandler(kuaidailiPageHandler).setThreadNum(1).
                addHandler(new ConsoleReduceHandler()).
                setPayload(Payload.custom()).
                isAsync(true).
                start();
    }

}
