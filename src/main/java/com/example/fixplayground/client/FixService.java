package com.example.fixplayground.client;


import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import quickfix.Session;
import quickfix.SessionNotFound;
import quickfix.field.*;

@Service
class FixService {
    private SessionManager sessionManager;
    private SimpMessagingTemplate template;
    FixService(SimpMessagingTemplate template) {
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

    public void sendOrder(Order order) {
        System.out.println("Processing Send order " + order.getMsgType());
        if ("NewOrderSingle".equals(order.getMsgType())) {
            try {
                quickfix.fix42.NewOrderSingle newOrderSingle = new quickfix.fix42.NewOrderSingle(
                        new ClOrdID(order.getFields().get("ClOrdID")),
                        new HandlInst('1'),
                        new Symbol(order.getFields().get("Symbol")),
                        new Side(Side.BUY),
                        new TransactTime(),
                        new OrdType(OrdType.MARKET));
                newOrderSingle.set(new OrderQty(10));

                Session.sendToTarget(newOrderSingle, sessionManager.getInitiator().getSessions().get(0));
            } catch (SessionNotFound sessionNotFound) {
                sessionNotFound.printStackTrace();
            }
        }
    }
}
