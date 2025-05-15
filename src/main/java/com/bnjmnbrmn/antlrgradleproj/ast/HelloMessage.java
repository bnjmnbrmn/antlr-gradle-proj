package com.bnjmnbrmn.antlrgradleproj.ast;

public class HelloMessage extends Message {
    private final String name; // The ID part of the message

    public HelloMessage(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "Hello";
    }

    @Override
    public String getContent() {
        return name;
    }
}
