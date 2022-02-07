package org.twitterApp.service;

import org.twitterApp.exceptions.errors.TwitterAuthenticationException;
import org.twitterApp.model.Tweet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface TwitterApiService {

    Map<String, List<Tweet>> getTweets(String searchTweet) throws TwitterAuthenticationException, IOException;
}
