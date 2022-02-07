package org.twitterApp.utils;

import org.twitterApp.model.Tweet;
import org.twitterApp.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMockUtils {

    public static List<Tweet> buildListTweets() {
        List<Tweet> tweetList = new ArrayList<>();
        tweetList.add(buildTweet());
        return tweetList;
    }

    public static Tweet buildTweet() {
        Tweet tweet = new Tweet();
        tweet.setCreationDate(new Date());
        tweet.setMessageId("1");
        tweet.setUser(buildUser());
        tweet.setMessageText("tweet1");
        return tweet;
    }

    public static User buildUser() {
        User user = new User();
        user.setUserId("1");
        user.setCreationDate(new Date());
        user.setName("User1");
        user.setScreenName("user1Screen");
        return user;
    }

}
