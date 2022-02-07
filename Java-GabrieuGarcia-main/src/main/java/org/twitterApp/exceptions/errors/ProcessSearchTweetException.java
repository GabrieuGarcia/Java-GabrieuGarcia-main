package org.twitterApp.exceptions.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ProcessSearchTweetException extends RuntimeException {
    public ProcessSearchTweetException(String message) {
        super(message);
    }
}
