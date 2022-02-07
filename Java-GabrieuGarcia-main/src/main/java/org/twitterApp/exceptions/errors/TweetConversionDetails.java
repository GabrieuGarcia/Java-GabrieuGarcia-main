package org.twitterApp.exceptions.errors;

public class TweetConversionDetails {

    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String message;

    private TweetConversionDetails() {
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

        public TweetConversionDetails build() {
            TweetConversionDetails tweetConversionDetails = new TweetConversionDetails();
            tweetConversionDetails.detail = this.detail;
            tweetConversionDetails.title = this.title;
            tweetConversionDetails.timestamp = this.timestamp;
            tweetConversionDetails.status = this.status;
            tweetConversionDetails.message = this.message;
            return tweetConversionDetails;
        }
    }

}
