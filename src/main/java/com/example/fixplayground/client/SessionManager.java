package com.example.fixplayground.client;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import quickfix.*;

import java.io.IOException;
import java.io.InputStream;

public class SessionManager {
    private Initiator initiator;
    SimpMessagingTemplate template;

    public SessionManager(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void createSession() {

        InputStream inputStream = SessionManager.class.getResourceAsStream("fixconfig.cfg");
        try {
            SessionSettings settings = new SessionSettings(inputStream);
            inputStream.close();
            if (initiator == null || !initiator.isLoggedOn()) {
                FixInitiator fixInitiator = new FixInitiator();
                MessageStoreFactory messageStoreFactory = new MemoryStoreFactory();
                LogFactory logFactory = new MyLog(template);
                MessageFactory messageFactory = new DefaultMessageFactory();
                initiator = initiator == null ? new SocketInitiator(fixInitiator, messageStoreFactory, settings, logFactory, messageFactory) : initiator;
                initiator.start();
            }
        } catch (ConfigError | IOException configError) {
            configError.printStackTrace();
        }

    }

    public void disconnectSession() {
        if (initiator != null) {
            initiator.stop();
        }
    }
}
