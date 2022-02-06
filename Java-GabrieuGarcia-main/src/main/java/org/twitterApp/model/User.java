package org.twitterApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.twitterApp.constants.TwitterConstants;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty(TwitterConstants.USER_ID)
    private String userId;

    @JsonProperty(TwitterConstants.CREATION)
    private Date creationDate;

    @JsonProperty(TwitterConstants.NAME)
    private String name;

    @JsonProperty(TwitterConstants.SCREEN_NAME)
    private String screenName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
