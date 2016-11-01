
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RatingReviewVO implements IValueObject {

    /**
     * 
     */
    private static final long serialVersionUID = 8L;

    private String responseID;

    private String expiryTime;

    public String getResponseID() {
        return responseID;
    }

    public void setResponseID(String responseID) {
        this.responseID = responseID;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    // Payload
    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public static class Payload implements Serializable{
        private boolean HasErrors;

        private int Offset;

        private String Locale;

        @SerializedName("Errors")
        private List<Error> errors = new ArrayList<Error>();

        public void setErrors(List<Error> errors) {
            this.errors = errors;
        }

        public List<Error> getErrors() {
            return errors;
        }

        public class Error implements Serializable {

            @SerializedName("Message")
            @Expose
            private String message;

            @SerializedName("Code")
            @Expose
            private String code;

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

        }

        public boolean isHasErrors() {
            return HasErrors;
        }

        public void setHasErrors(boolean hasErrors) {
            HasErrors = hasErrors;
        }

        public int getOffset() {
            return Offset;
        }

        public void setOffset(int offset) {
            Offset = offset;
        }

        public String getLocale() {
            return Locale;
        }

        public void setLocale(String locale) {
            Locale = locale;
        }

        private int statusCode;

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        private boolean isSuccessful;

        public boolean isSuccessful() {
            return isSuccessful;
        }

        public void setSuccessful(boolean isSuccessful) {
            this.isSuccessful = isSuccessful;
        }

        private String statusReason;

        public String getStatusReason() {
            return statusReason;
        }

        public void setStatusReason(String statusReason) {
            this.statusReason = statusReason;
        }

        private int TotalResults;

        public int getTotalResults() {
            return TotalResults;
        }

        public void setTotalResults(int totalResults) {
            TotalResults = totalResults;
        }

        private List<Result> Results;

        public List<Result> getResults() {
            return Results;
        }

        public void setResults(List<Result> results) {
            Results = results;
        }

        public static class Result implements Serializable {

            private String UserNickname;

            private String UserLocation;

            private String AuthorId;

            private String Title;

            private String SubmissionTime;

            private String Pros;

            private String Cons;

            private int Rating;

            private int RatingRange;

            private String ReviewText;

            private String LastModeratedTime;

            public String getUserNickname() {
                return UserNickname;
            }

            public void setUserNickname(String userNickname) {
                UserNickname = userNickname;
            }

            public String getUserLocation() {
                return UserLocation;
            }

            public void setUserLocation(String userLocation) {
                UserLocation = userLocation;
            }

            public String getAuthorId() {
                return AuthorId;
            }

            public void setAuthorId(String authorId) {
                AuthorId = authorId;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String title) {
                Title = title;
            }

            public String getSubmissionTime() {
                return SubmissionTime;
            }

            public void setSubmissionTime(String submissionTime) {
                SubmissionTime = submissionTime;
            }

            public int getRating() {
                return Rating;
            }

            public void setRating(int rating) {
                Rating = rating;
            }

            public int getRatingRange() {
                return RatingRange;
            }

            public void setRatingRange(int ratingRange) {
                RatingRange = ratingRange;
            }

            public String getReviewText() {
                return ReviewText;
            }

            public void setReviewText(String reviewText) {
                ReviewText = reviewText;
            }

            private SecondaryRating SecondaryRatings;

            public SecondaryRating getSecondaryRatings() {
                return SecondaryRatings;
            }

            public void setSecondaryRatings(SecondaryRating secondaryRatings) {
                SecondaryRatings = secondaryRatings;
            }

            public String getLastModeratedTime() {
                return LastModeratedTime;
            }

            public void setLastModeratedTime(String lastModeratedTime) {
                LastModeratedTime = lastModeratedTime;
            }

            public String getPros() {
                return Pros;
            }

            public void setPros(String pros) {
                Pros = pros;
            }

            public String getCons() {
                return Cons;
            }

            public void setCons(String cons) {
                Cons = cons;
            }

            public static class SecondaryRating  implements Serializable{

                private Value Value;

                private Value Quality;

                private Value Style;

                public Value getValue() {
                    return Value;
                }

                public void setValue(Value value) {
                    Value = value;
                }

                public Value getQuality() {
                    return Quality;
                }

                public void setQuality(Value quality) {
                    Quality = quality;
                }

                public Value getStyle() {
                    return Style;
                }

                public void setStyle(Value style) {
                    Style = style;
                }

                public static class Value implements Serializable {
                    private String ValueLabel;

                    private String MaxLabel;

                    private String Label;

                    private String Id;

                    private int ValueRange;

                    private String MinLabel;

                    private String DisplayType;

                    private int Value;

                    public String getValueLabel() {
                        return ValueLabel;
                    }

                    public void setValueLabel(String valueLabel) {
                        ValueLabel = valueLabel;
                    }

                    public String getMaxLabel() {
                        return MaxLabel;
                    }

                    public void setMaxLabel(String maxLabel) {
                        MaxLabel = maxLabel;
                    }

                    public String getLabel() {
                        return Label;
                    }

                    public void setLabel(String label) {
                        Label = label;
                    }

                    public String getId() {
                        return Id;
                    }

                    public void setId(String id) {
                        Id = id;
                    }

                    public String getMinLabel() {
                        return MinLabel;
                    }

                    public void setMinLabel(String minLabel) {
                        MinLabel = minLabel;
                    }

                    public String getDisplayType() {
                        return DisplayType;
                    }

                    public void setDisplayType(String displayType) {
                        DisplayType = displayType;
                    }

                    public int getValueRange() {
                        return ValueRange;
                    }

                    public void setValueRange(int valueRange) {
                        ValueRange = valueRange;
                    }

                    public int getValue() {
                        return Value;
                    }

                    public void setValue(int value) {
                        Value = value;
                    }
                }
            }
        }

        private ReviewStatistics ReviewStatistics;

        public ReviewStatistics getReviewStatistics() {
            return ReviewStatistics;
        }

        public void setReviewStatistics(ReviewStatistics reviewStatistics) {
            ReviewStatistics = reviewStatistics;
        }

        public static class ReviewStatistics implements Serializable {

            private int TotalReviewCount;

            private int RecommendedCount;

            private float AverageOverallRating;

            private int OverallRatingRange;

            public int getTotalReviewCount() {
                return TotalReviewCount;
            }

            public void setTotalReviewCount(int totalReviewCount) {
                TotalReviewCount = totalReviewCount;
            }

            public int getRecommendedCount() {
                return RecommendedCount;
            }

            public void setRecommendedCount(int recommendedCount) {
                RecommendedCount = recommendedCount;
            }

            private SecondaryRatingsAverages SecondaryRatingsAverages;

            public float getAverageOverallRating() {
                return AverageOverallRating;
            }

            public void setAverageOverallRating(float averageOverallRating) {
                AverageOverallRating = averageOverallRating;
            }

            public int getOverallRatingRange() {
                return OverallRatingRange;
            }

            public void setOverallRatingRange(int overallRatingRange) {
                OverallRatingRange = overallRatingRange;
            }

            public SecondaryRatingsAverages getSecondaryRatingsAverages() {
                return SecondaryRatingsAverages;
            }

            public void
                    setSecondaryRatingsAverages(SecondaryRatingsAverages secondaryRatingsAverages) {
                SecondaryRatingsAverages = secondaryRatingsAverages;
            }

            public static class SecondaryRatingsAverages implements Serializable {

                private Range Value;

                private Range Quality;

                private Range Style;

                public Range getValue() {
                    return Value;
                }

                public void setValue(Range value) {
                    Value = value;
                }

                public Range getQuality() {
                    return Quality;
                }

                public void setQuality(Range quality) {
                    Quality = quality;
                }

                public Range getStyle() {
                    return Style;
                }

                public void setStyle(Range style) {
                    Style = style;
                }

                public static class Range implements Serializable {
                    private String ID;

                    private float AverageRating;

                    public String getID() {
                        return ID;
                    }

                    public void setID(String iD) {
                        ID = iD;
                    }

                    public float getAverageRating() {
                        return AverageRating;
                    }

                    public void setAverageRating(float averageRating) {
                        AverageRating = averageRating;
                    }

                }

            }
        }
    }

}
