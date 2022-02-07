package org.twitterApp.exceptions.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Class to treat Tweets not found
 * @author Gabriel Fernandes Garcia
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TweetConversionException extends RuntimeException {
    public TweetConversionException(String message) {
        super(message);
    }
}
