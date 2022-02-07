package org.twitterApp.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.twitterApp.exceptions.errors.*;

import java.util.Date;

/**
 * Class Responsible for handle the Exceptions on the API
 * @author Gabriel Fernandes Garcia
 */
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * Method Responsible for all the exceptions regarding of not found tweets.
     * @param tweetNotFoundException
     * @return TweetNotFoundDetails
     */
    @ExceptionHandler(TweetNotFoundException.class)
    public ResponseEntity<?> handleTweetNotFoundException(TweetNotFoundException tweetNotFoundException) {
        TweetNotFoundDetails details = TweetNotFoundDetails.Builder.builder()
                .title("Tweet Not Found")
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .detail(tweetNotFoundException.getMessage())
                .message(tweetNotFoundException.getClass().getName())
                .build();
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    /**
     * Method Responsible for the exceptions regarding of null input.
     * @param emptySearchException
     * @return EmptySearchDetails
     */
    @ExceptionHandler(EmptySearchException.class)
    public ResponseEntity<?> handleTweetNotFoundException(EmptySearchException emptySearchException) {
        EmptySearchDetails details = EmptySearchDetails.Builder.builder()
                .title("Tweet Not Found")
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .detail(emptySearchException.getMessage())
                .message(emptySearchException.getClass().getName())
                .build();
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
}
