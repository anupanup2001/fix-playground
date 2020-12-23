package com.example.fixplayground.client;


import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
class SessionManagerService {
    private SessionManager sessionManager;
    private SimpMessagingTemplate template;
    SessionManagerService(SimpMessagingTemplate template) {
        this.template = template;
        this.sessionManager = new SessionManager(template);
    }

    public void connect() {
        System.out.println("Connecting to fix session localhost");
        sessionManager.createSession();
    }

    public void disconnect() {
        System.out.println("Disconnecting from fix session localhost");
        sessionManager.disconnectSession();
    }
}
