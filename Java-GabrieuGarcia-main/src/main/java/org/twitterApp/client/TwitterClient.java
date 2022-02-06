package org.twitterApp.client;

import org.twitterApp.exceptions.errors.TwitterAuthenticationException;
import org.twitterApp.model.Tweet;

import java.io.IOException;
import java.util.List;

public interface TwitterClient {

    List<Tweet> getTweetsBySearch(String searchTweet) throws TwitterAuthenticationException, IOException;

}
