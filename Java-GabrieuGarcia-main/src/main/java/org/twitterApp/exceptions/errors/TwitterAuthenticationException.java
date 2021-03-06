package org.twitterApp.exceptions.errors;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Class to treat Tweets not found
 * @author Gabriel Fernandes Garcia
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TwitterAuthenticationException extends RuntimeException {
	public TwitterAuthenticationException(String message) {
		super(message);
	}
}
