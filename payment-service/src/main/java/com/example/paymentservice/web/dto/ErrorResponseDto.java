package com.example.paymentservice.web.dto;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

public class ErrorResponseDto {
    private String uri;

    private String type;

    private String message;

    private String timestamp;

    public ErrorResponseDto(String type, String message) {
        this.uri = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        this.timestamp = LocalDateTime.now().toString();
        this.type = type;
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
