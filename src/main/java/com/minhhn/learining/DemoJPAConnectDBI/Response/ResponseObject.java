package com.minhhn.learining.DemoJPAConnectDBI.Response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseObject {
    private String status;
    private String message;
    private int code;
    private Object object;

}
