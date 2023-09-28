package com.springusers.rest.webservices.usersweb.services.models.exceptions;

import java.time.LocalDateTime;
 /**
 * Error class to give an structured response in case of an exception
 * <br>
 * Json:
 * {
 *     "timestamp": "2090-08-19T13:28:16.777397",
 *     "message": "id not found",
 *     "details": "uri=/users/1000"
 * }
 *
 */
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
