package com.example.fixplayground.client;

import java.util.Map;

public class Order {
    private String msgType;
    private Map<String, String> fields;
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }
}
