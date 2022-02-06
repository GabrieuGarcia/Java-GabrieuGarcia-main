package org.twitterApp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.twitterApp.client.TwitterClient;
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
        tweetList = twitterClient.getTweetsBySearch(searchTweet);
        sortMapTweetUsersByCreationDate();
        sortMapToUserTweetList();
    }

    /**
     * Sort the tweetsByUser by users creation date.
     */
    private void sortMapTweetUsersByCreationDate() {
        LOGGER.info("Init filterTweetsByUserCreationDate");
        tweetsByUser = tweetList.stream()
            .sorted((tweet1,tweet2) -> tweet1.getUser().getCreationDate().compareTo(tweet2.getUser().getCreationDate()))
            .collect(Collectors.groupingBy(p -> p.getUser().getUserId()));
    }

    /**
     * Sort the tweetsByUser by users creation date.
     */
    private void sortMapToUserTweetList() {
        for (List<Tweet> userTweetList : tweetsByUser.values()) {
            userTweetList.sort((user1, user2) -> user1.compareTo(user2));
        }
    }
}
