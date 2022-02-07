package org.twitterApp.exceptions.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Class to treat empty search
 * @author Gabriel Fernandes Garcia
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptySearchException extends RuntimeException {
    public EmptySearchException(String message) {
        super(message);
    }
}
