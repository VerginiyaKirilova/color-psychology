package com.colors.colorApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LogClientService {

    private final RestTemplate restTemplate;

    @Value("${logging.service.url}")
    private String loggingServiceUrl;

    public LogClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void log(String username, String message, String action) {
        try {
            Map<String, String> payload = new HashMap<>();
            payload.put("username", username);
            payload.put("message", message);
            payload.put("action", action);

            restTemplate.postForEntity(loggingServiceUrl + "/api/logs", payload, Void.class);
        } catch (Exception e) {
            System.err.println("Грешка при логване: " + e.getMessage());
        }
    }
}
