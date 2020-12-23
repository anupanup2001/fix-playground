package com.example.fixplayground.client;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import quickfix.Log;
import quickfix.LogFactory;
import quickfix.SessionID;

public class MyLog implements LogFactory, Log {

    private SimpMessagingTemplate template;
    public MyLog(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Override
    public Log create(SessionID sessionID) {
        return new MyLog(template);
    }

    @Override
    public void clear() {

    }

    @Override
    public void onIncoming(String s) {
        System.out.println("Yay - incoming: " + s);
        this.template.convertAndSend("/topic/data", s);
    }

    @Override
    public void onOutgoing(String s) {
        System.out.println("Yay - outgoing: " + s);
        this.template.convertAndSend("/topic/data", s);
    }

    @Override
    public void onEvent(String s) {
        System.out.println("Yay - event: " + s);

    }

    @Override
    public void onErrorEvent(String s) {
        System.out.println("Yay - error event: " + s);

    }
}
