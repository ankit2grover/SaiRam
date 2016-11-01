
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WriteReviewVO implements IValueObject {

    private static final long serialVersionUID = 1L;

    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload {

        @SerializedName("Data")
        private Data data;

        @SerializedName("HasErrors")
        private Boolean hasErrors;

        @SerializedName("Form")
        private List<Object> form = new ArrayList<Object>();

        @SerializedName("FormErrors")
        private FormErrors formErrors;

        @SerializedName("AuthorSubmissionToken")
        private String authorSubmissionToken;

        @SerializedName("TypicalHoursToPost")
        private Integer typicalHoursToPost;

        @SerializedName("SubmissionId")
        private String submissionId;

        @SerializedName("Review")
        private Review review;

        @SerializedName("Locale")
        private String locale;

        @SerializedName("Errors")
        private List<Error> errors = new ArrayList<Error>();

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Boolean getHasErrors() {
            return hasErrors;
        }

        public void setHasErrors(Boolean hasErrors) {
            this.hasErrors = hasErrors;
        }

        public List<Object> getForm() {
            return form;
        }

        public void setForm(List<Object> form) {
            this.form = form;
        }

        public FormErrors getFormErrors() {
            return formErrors;
        }

        public void setFormErrors(FormErrors formErrors) {
            this.formErrors = formErrors;
        }

        public String getAuthorSubmissionToken() {
            return authorSubmissionToken;
        }

        public void setAuthorSubmissionToken(String authorSubmissionToken) {
            this.authorSubmissionToken = authorSubmissionToken;
        }

        public Integer getTypicalHoursToPost() {
            return typicalHoursToPost;
        }

        public void setTypicalHoursToPost(Integer typicalHoursToPost) {
            this.typicalHoursToPost = typicalHoursToPost;
        }

        public String getSubmissionId() {
            return submissionId;
        }

        public void setSubmissionId(String submissionId) {
            this.submissionId = submissionId;
        }

        public Review getReview() {
            return review;
        }

        public void setReview(Review review) {
            this.review = review;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public List<Error> getErrors() {
            return errors;
        }

        public void setErrors(List<Error> errors) {
            this.errors = errors;
        }

        public class FormErrors implements Serializable {

            /**
			 * 
			 */
            private static final long serialVersionUID = 1L;

            @SerializedName("FieldErrors")
            private FieldErrors fieldErrors;

            @SerializedName("FieldErrorsOrder")
            private List<Object> fieldErrorOrderList = new ArrayList<Object>();

            public List<Object> getFieldErrorOrderList() {
                return fieldErrorOrderList;
            }

            public void setFieldErrorOrderList(List<Object> fieldErrorOrderList) {
                this.fieldErrorOrderList = fieldErrorOrderList;
            }

            public FieldErrors getFieldErrors() {
                return fieldErrors;
            }

            public void setFieldErrors(FieldErrors fieldErrors) {
                this.fieldErrors = fieldErrors;
            }

            public class FieldErrors implements Serializable {

                /**
				 * 
				 */
                private static final long serialVersionUID = 1L;

                private UserNickName usernickname;

                public class UserNickName {
                    @SerializedName("Field")
                    private String field;

                    @SerializedName("Message")
                    private String message;

                    @SerializedName("Code")
                    private String code;

                    public String getField() {
                        return field;
                    }

                    public void setField(String field) {
                        this.field = field;
                    }

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

                public UserNickName getUsernickname() {
                    return usernickname;
                }

                public void setUsernickname(UserNickName usernickname) {
                    this.usernickname = usernickname;
                }
            }
        }

        public class Review {

            @SerializedName("SendEmailAlertWhenPublished")
            private Boolean sendEmailAlertWhenPublished;

            @SerializedName("SendEmailAlertWhenCommented")
            private Boolean sendEmailAlertWhenCommented;

            @SerializedName("SubmissionTime")
            private String submissionTime;

            @SerializedName("Rating")
            private Integer rating;

            @SerializedName("IsRecommended")
            private Object isRecommended;

            @SerializedName("ReviewText")
            private String reviewText;

            @SerializedName("TypicalHoursToPost")
            private Object typicalHoursToPost;

            @SerializedName("Id")
            private Object id;

            @SerializedName("SubmissionId")
            private Object submissionId;

            @SerializedName("Title")
            private String title;

            public Boolean getSendEmailAlertWhenPublished() {
                return sendEmailAlertWhenPublished;
            }

            public void setSendEmailAlertWhenPublished(Boolean sendEmailAlertWhenPublished) {
                this.sendEmailAlertWhenPublished = sendEmailAlertWhenPublished;
            }

            public Boolean getSendEmailAlertWhenCommented() {
                return sendEmailAlertWhenCommented;
            }

            public void setSendEmailAlertWhenCommented(Boolean sendEmailAlertWhenCommented) {
                this.sendEmailAlertWhenCommented = sendEmailAlertWhenCommented;
            }

            public String getSubmissionTime() {
                return submissionTime;
            }

            public void setSubmissionTime(String submissionTime) {
                this.submissionTime = submissionTime;
            }

            public Integer getRating() {
                return rating;
            }

            public void setRating(Integer rating) {
                this.rating = rating;
            }

            public Object getIsRecommended() {
                return isRecommended;
            }

            public void setIsRecommended(Object isRecommended) {
                this.isRecommended = isRecommended;
            }

            public String getReviewText() {
                return reviewText;
            }

            public void setReviewText(String reviewText) {
                this.reviewText = reviewText;
            }

            public Object getTypicalHoursToPost() {
                return typicalHoursToPost;
            }

            public void setTypicalHoursToPost(Object typicalHoursToPost) {
                this.typicalHoursToPost = typicalHoursToPost;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getSubmissionId() {
                return submissionId;
            }

            public void setSubmissionId(Object submissionId) {
                this.submissionId = submissionId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

        }

        public class Data {

        }

        public class Error {

            @SerializedName("Message")
            private String message;

            @SerializedName("Code")
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
    }
}
