package com.minhhn.learining.DemoJPAConnectDBI.Constants;


public enum StatusCode {
    SUCCESS(200), CREATED(201), BAD_REQUEST(400), UNAUTHORIZED(401);
    private int value;
    StatusCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
