package org.twitterApp.exceptions.errors;

import java.util.Locale;

public class TweetNotFoundDetails {

    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String message;

    private TweetNotFoundDetails() {
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }


    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String message;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public TweetNotFoundDetails build() {
            TweetNotFoundDetails tweetNotFoundDetails = new TweetNotFoundDetails();
            tweetNotFoundDetails.detail = this.detail;
            tweetNotFoundDetails.title = this.title;
            tweetNotFoundDetails.timestamp = this.timestamp;
            tweetNotFoundDetails.status = this.status;
            tweetNotFoundDetails.message = this.message;
            return tweetNotFoundDetails;
        }
    }
}
