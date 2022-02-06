package org.twitterApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.twitterApp.constants.TwitterConstants;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweet implements Comparable{

    @JsonProperty(TwitterConstants.MESSAGE_ID)
    private String messageId;

    @JsonProperty(TwitterConstants.CREATION)
    private Date creationDate;

    @JsonProperty(TwitterConstants.TEXT)
    private String messageText;

    @JsonProperty(TwitterConstants.USER)
    private User user;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int compareTo(Object o) {
        final int EQUAL = 0;
        int result;

        Tweet oTweet = (Tweet) o;

        if(this == oTweet)
            result = EQUAL;
        else
            result = this.getCreationDate().compareTo(oTweet.getCreationDate());

        return result;
    }

    @Override
    public String toString(){
        return "Tweet: [" +
                TwitterConstants.MESSAGE_ID + ": " + messageId + "," +
                TwitterConstants.CREATION + ": " + creationDate + "," +
                TwitterConstants.TEXT + ": " + messageText + "," +
                TwitterConstants.USER + ": " + user.toString() +
                "]";
    }
}
