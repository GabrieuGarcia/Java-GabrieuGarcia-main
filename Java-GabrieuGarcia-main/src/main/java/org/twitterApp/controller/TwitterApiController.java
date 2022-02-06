package org.twitterApp.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.twitterApp.exceptions.errors.TweetNotFoundException;
import org.twitterApp.exceptions.errors.TwitterAuthenticationException;
import org.twitterApp.model.Tweet;
import org.twitterApp.service.TwitterApiService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Controller class for the request.
 *
 * @author Gabriel Fernandes Garcia
 */
@Controller
@RequestMapping(path = "/twitter-api")
public class TwitterApiController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TwitterApiController.class);

    private final TwitterApiService twitterApiService;

    public TwitterApiController(TwitterApiService twitterApiService) {
        this.twitterApiService = twitterApiService;
    }

    /**
     * Metho Responsible for Rest requests to serach for tweets
     * @param searchTweet
     * @return <Map<String, List<Tweet>>
     * @throws TwitterAuthenticationException
     * @throws IOException
     */
    @GetMapping("/{searchTweet}")
    public ResponseEntity<Map<String, List<Tweet>>> searchTweets(@PathVariable String searchTweet) throws TwitterAuthenticationException, IOException {
        LOGGER.info("Initializing the search with parameter: " + searchTweet);
        Map<String, List<Tweet>> response = twitterApiService.getTweets(searchTweet);
           if(response == null)
               throw new TweetNotFoundException("Tweets no founds");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
