package com.xqs.videodemo.network.component;


public class JDException extends RuntimeException {

    public int status;
    public String message;


    public JDException(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
