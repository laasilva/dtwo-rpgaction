package com.dtwo.rpgaction.model.commons;

import java.util.Hashtable;
import java.util.Map;

public class ScopeContext {
    private Map<String, Object> payloadMap = new Hashtable<>();
    private Object currentPayload;

    public Map<String, Object> getPayloadMap() {
        return payloadMap;
    }

    public void setPayloadMap(Map<String, Object> payloadMap) {
        this.payloadMap = payloadMap;
    }

    public Object getCurrentPayload() {
        return currentPayload;
    }

    public void setCurrentPayload(Object currentPayload) {
        this.currentPayload = currentPayload;
    }

    public void addToScopePayload(String key, Object payload) {
        payloadMap.put(key, (Object) payload);
    }
}
