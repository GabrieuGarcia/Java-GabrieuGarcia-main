package org.twitterApp.exceptions.errors;

public class EmptySearchDetails {

    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String message;

    private EmptySearchDetails() {
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

        public EmptySearchDetails build() {
            EmptySearchDetails emptySearchDetails = new EmptySearchDetails();
            emptySearchDetails.detail = this.detail;
            emptySearchDetails.title = this.title;
            emptySearchDetails.timestamp = this.timestamp;
            emptySearchDetails.status = this.status;
            emptySearchDetails.message = this.message;
            return emptySearchDetails;
        }
    }

}
