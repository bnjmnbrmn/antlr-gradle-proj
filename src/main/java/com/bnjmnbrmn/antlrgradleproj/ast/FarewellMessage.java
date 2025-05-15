package com.bnjmnbrmn.antlrgradleproj.ast;

public class FarewellMessage extends Message {
    private final String name; // The ID part of the message

    public FarewellMessage(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "Farewell";
    }

    @Override
    public String getContent() {
        return name;
    }
}
