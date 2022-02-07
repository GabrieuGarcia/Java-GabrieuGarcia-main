package org.twitterApp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.twitterApp.client.TwitterClient;
import org.twitterApp.exceptions.errors.EmptySearchException;
import org.twitterApp.exceptions.errors.ProcessSearchTweetException;
import org.twitterApp.exceptions.errors.TwitterAuthenticationException;
import org.twitterApp.model.Tweet;
import org.twitterApp.service.TwitterApiService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TwitterApiServiceImpl implements TwitterApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterApiServiceImpl.class);

    private final TwitterClient twitterClient;
    private Map<String, List<Tweet>> tweetsByUser;
    private List<Tweet> tweetList;

    public TwitterApiServiceImpl(TwitterClient twitterClient) {
        this.twitterClient = twitterClient;
    }

    @Override
    public Map<String, List<Tweet>> getTweets(String searchTweet) throws TwitterAuthenticationException, IOException {
        processSearchTweets(searchTweet);
        return tweetsByUser;
    }

    /**
     * Method responsible for processing the search
     * @param searchTweet
     * @throws TwitterAuthenticationException
     * @throws IOException
     */
    private void processSearchTweets(String searchTweet) throws TwitterAuthenticationException, IOException {
        if(searchTweet == null || searchTweet.equals("")){
            throw new EmptySearchException("The search was empty!");
        }

        try {
            tweetList = twitterClient.getTweetsBySearch(searchTweet);
            sortMapTweetUsersByCreationDate();
            sortMapToUserTweetList();
        } catch (ProcessSearchTweetException e) {
            throw new ProcessSearchTweetException("It was not possible to process the tweets!");
        }
    }

    /**
     * Sort the tweetsByUser by users creation date.
     */
    private void sortMapTweetUsersByCreationDate() {
        LOGGER.info("Sorting Tweet List for the creation date");
        tweetsByUser = tweetList.stream()
            .sorted((tweet1,tweet2) -> tweet1.getUser().getCreationDate().compareTo(tweet2.getUser().getCreationDate()))
            .collect(Collectors.groupingBy(p -> p.getUser().getUserId()));
    }

    /**
     * Sort the tweets by creation date.
     */
    private void sortMapToUserTweetList() {
        LOGGER.info("Sorting Tweet List for the creation date");
        tweetsByUser.forEach((users, tweets) -> tweets.stream().sorted((tweet1,tweet2) -> tweet1.getCreationDate().compareTo(tweet2.getCreationDate())));
    }
}
