package org.twitterApp.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.twitterApp.client.TwitterClient;
import org.twitterApp.controller.TwitterApiController;
import org.twitterApp.exceptions.errors.EmptySearchException;
import org.twitterApp.exceptions.errors.TweetNotFoundException;
import org.twitterApp.model.Tweet;
import org.twitterApp.service.TwitterApiService;
import org.twitterApp.utils.TestMockUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TwitterApiServiceImplTest {

    @InjectMocks
    private TwitterApiServiceImpl service;

    @Mock
    private TwitterClient twitterClient;

    @BeforeEach
    void setUp() {
        service = new TwitterApiServiceImpl(twitterClient);
    }

    @Test
    void getTweets_success() throws IOException {
        //given
        String search = "test";
        when(twitterClient.getTweetsBySearch(search)).thenReturn(TestMockUtils.buildListTweets());
        //when
        Map<String, List<Tweet>> response = service.getTweets(search);
        //then
        assertNotNull(response);
        verify(twitterClient, atLeast(1)).getTweetsBySearch(search);
    }

    @Test
    void searchTweets_exception() throws TweetNotFoundException, IOException {
        //when
        //then
        assertThatThrownBy(() -> service.getTweets(null))
                .isInstanceOf(EmptySearchException.class)
                .hasMessageContaining("The search was empty!");
    }
}