package com.robertfagaras.lpc.cron;

import com.robertfagaras.lpc.utils.JavaWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;

@Component
public class StartAction {

    @Autowired
    JavaWatchService javaWatchService;

    @EventListener(ApplicationReadyEvent.class)
    public void scheduledInsertInDataBase() throws ParseException, InterruptedException {
        System.out.println("A");
        javaWatchService.processEvents();
    }

}
