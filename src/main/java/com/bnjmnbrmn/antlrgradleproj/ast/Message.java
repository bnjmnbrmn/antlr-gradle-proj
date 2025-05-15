package com.bnjmnbrmn.antlrgradleproj.ast;

public abstract class Message {
    public abstract String getType();
    public abstract String getContent();

    @Override
    public String toString() {
        return getType() + "(" + getContent() + ")";
    }
}
