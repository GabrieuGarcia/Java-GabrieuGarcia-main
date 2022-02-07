package org.twitterApp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.twitterApp.exceptions.errors.TweetConversionException;
import org.twitterApp.model.Tweet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class TwitterUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterUtils.class);

    private static final int MAX_TWEETS = 100;
    private static final int MAX_TIME = 30000;

    /**
     * Method responsible convert HttpResponse into TweetList
     * @param httpResponse
     * @return List<Tweet>
     * @throws IOException
     */
    public static List<Tweet> convertHttpResponseInTweetList(HttpResponse httpResponse) throws IOException {
        LOGGER.info("Initializing the convertion of the http response into a Tweet list");
        InputStream in = httpResponse.getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            List<Tweet> tweets = convertBufferedReaderInTweets(reader);
            return tweets;
        } catch (TweetConversionException e) {
             throw new TweetConversionException("It was not possibwl to convert the tweet");
        }
    }

    /**
     * Method responsible convert BufferedReader into a List of Tweets
     * @param reader
     * @return List<Tweet>
     * @throws IOException
     */
    private static List<Tweet> convertBufferedReaderInTweets(BufferedReader reader) throws IOException {
        LOGGER.info("Initializing the convertion of the Bufferd Reader into a Tweet list");
        List<Tweet> tweetList = new ArrayList<>();
        int counter = 0;
        long startTime = System.currentTimeMillis();

        String line = reader.readLine();
        ObjectMapper mapper = formatDateOfObjectMapper();

        while (line != null && counter < MAX_TWEETS && System.currentTimeMillis() - startTime < MAX_TIME) {
            tweetList.add(mapper.readValue(line, Tweet.class));
            line = reader.readLine();
            counter++;
            LOGGER.info("Tweets found: " + counter);
        }
        LOGGER.info("End searching for Tweets!");
        return tweetList;
    }

    /**
     * Method responsible to format da date Of ObjectMapper
     * @return ObjectMapper
     */
    private static ObjectMapper formatDateOfObjectMapper() {
        ObjectMapper mapper =  new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
        mapper.setDateFormat(dateFormat);
        return mapper;
    }
}
