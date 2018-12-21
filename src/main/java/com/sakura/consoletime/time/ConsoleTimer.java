package com.sakura.consoletime.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class ConsoleTimer {

    Logger logger = LoggerFactory.getLogger(ConsoleTimer.class);

    private Timer timer;

    @PostConstruct
    public void init() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Thread(() -> logger.info("This is a test message log!")).start();
            }
        }, 0,1000);
    }

    @PreDestroy
    public void destory() {
        timer.cancel();
    }
}
