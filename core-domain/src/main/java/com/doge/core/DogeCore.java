package com.doge.core;

public class DogeCore {

    private static final DogeCore instance = new DogeCore();

    public static DogeCore get(){
        return instance;
    }

    static {
    }
}
