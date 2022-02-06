package org.twitterApp.exceptions.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Class to treat Tweets not found
 * @author Gabriel Fernandes Garcia
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TweetNotFoundException extends RuntimeException {
    public TweetNotFoundException(String message) {
        super(message);
    }
}
