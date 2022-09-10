package com.minhhn.learining.DemoJPAConnectDBI.Constants;

public enum StatusRequest {
    SUCCESS("success"), FAIL("fail");
    private String result;

    StatusRequest(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }


}
