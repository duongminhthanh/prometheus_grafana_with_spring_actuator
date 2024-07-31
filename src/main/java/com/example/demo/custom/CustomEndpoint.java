package com.example.demo.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "custom")
public class CustomEndpoint {

    @ReadOperation
    public Map<String, String> customEndpoint() {
        Map<String, String> customInfo = new HashMap<>();
        customInfo.put("customKey1", "customValue1");
        customInfo.put("customKey2", "customValue2");
        return customInfo;
    }
}
