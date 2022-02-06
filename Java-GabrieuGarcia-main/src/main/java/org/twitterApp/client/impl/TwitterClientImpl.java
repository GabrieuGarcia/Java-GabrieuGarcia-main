package org.twitterApp.client.impl;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.twitterApp.authentication.TwitterAuthenticator;
import org.twitterApp.client.TwitterClient;
import org.twitterApp.exceptions.errors.TwitterAuthenticationException;
import org.twitterApp.model.Tweet;
import org.twitterApp.utils.TwitterUtils;

import java.io.IOException;
import java.util.List;

@Component
public class TwitterClientImpl implements TwitterClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterClientImpl.class);
    private static final String TRACK_SEARCH = "?track=";

    private TwitterAuthenticator twitterAuthenticator;
    private final String endpointTwitter;
    private final String consumerKey;
    private final String consumerSecret;

    public TwitterClientImpl(TwitterAuthenticator twitterAuthenticator,
                             @Value("${endpoint.twitter}") String endpointTwitter,
                             @Value("${consumer.key}") String consumerKey,
                             @Value("${consumer.secret}") String consumerSecret) {

        this.twitterAuthenticator = twitterAuthenticator;
        this.endpointTwitter = endpointTwitter;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }

    @Override
    public List<Tweet> getTweetsBySearch(String searchTweet) throws TwitterAuthenticationException, IOException {
        HttpResponse httpResponse = buildHttpResponse(searchTweet);
        return TwitterUtils.convertHttpResponseInTweetList(httpResponse);
    }

    /**
     * Method Responsible for get the HTTP Response
     * @param searchTweet
     * @return HttpResponse
     * @throws IOException
     */
    private HttpResponse buildHttpResponse(String searchTweet) throws IOException, TwitterAuthenticationException {
        LOGGER.info("Building Http Response...");
            twitterAuthenticator = new TwitterAuthenticator(consumerKey, consumerSecret);
            HttpRequestFactory httpRequestFactory = twitterAuthenticator.getAuthorizedHttpRequestFactory();
            HttpRequest request = httpRequestFactory.buildGetRequest(new GenericUrl(endpointTwitter.concat(TRACK_SEARCH + searchTweet)));
            return request.execute();
    }
}
