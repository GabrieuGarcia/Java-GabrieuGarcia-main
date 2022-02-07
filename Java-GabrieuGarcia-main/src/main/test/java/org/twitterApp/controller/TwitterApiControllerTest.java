package org.twitterApp.controller;

import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.twitterApp.exceptions.errors.TweetNotFoundException;
import org.twitterApp.model.Tweet;
import org.twitterApp.service.TwitterApiService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TwitterApiControllerTest {

    private TwitterApiController controller;

    @Mock
    private TwitterApiService twitterApiService;

    @BeforeEach
    void setUp() {
        controller = new TwitterApiController(twitterApiService);
    }

    @Test
    void searchTweets_success() throws IOException {
        //given
        Map<String, List<Tweet>> map = new HashMap<>();
        when(twitterApiService.getTweets(anyString())).thenReturn(map);
        //when
        ResponseEntity<Map<String, List<Tweet>>> response = controller.searchTweets(anyString());
        //then
        verify(twitterApiService, atLeast(1)).getTweets(anyString());
    }

    @Test
    void searchTweets_exception() throws TweetNotFoundException, IOException {
        //given
        when(twitterApiService.getTweets(anyString())).thenReturn(null);

        //when
        //then
        assertThatThrownBy(() -> controller.searchTweets(anyString()))
                .isInstanceOf(TweetNotFoundException.class)
                .hasMessageContaining("No tweets found!");
    }
}