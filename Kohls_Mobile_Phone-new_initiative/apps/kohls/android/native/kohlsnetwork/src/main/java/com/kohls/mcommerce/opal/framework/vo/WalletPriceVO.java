
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class WalletPriceVO implements IValueObject {

    public String getUniqueResponseId() {
        return uniqueResponseId;
    }

    public void setUniqueResponseId(String uniqueResponseId) {
        this.uniqueResponseId = uniqueResponseId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    private String uniqueResponseId;

    private boolean success;

    private List<Error> errors;

    private Pricing pricing;

    public class Error implements Serializable {

        /**
		 * 
		 */
        private static final long serialVersionUID = 1L;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

        @Expose
        private String code;

        @Expose
        private String message;

        @Expose
        private String entity;
    }

    public class Pricing implements Serializable {

        /**
		 * 
		 */
        private static final long serialVersionUID = 1L;

        private List<AppliedKohlsCash> appliedKohlsCash;

        private String walletPrice;

        public String getWalletPrice() {
            return walletPrice;
        }

        public void setWalletPrice(String walletPrice) {
            this.walletPrice = walletPrice;
        }

        public class AppliedKohlsCash implements Serializable {

            /**
			 * 
			 */
            private static final long serialVersionUID = 1L;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getEffectiveStartDate() {
                return effectiveStartDate;
            }

            public void setEffectiveStartDate(String effectiveStartDate) {
                this.effectiveStartDate = effectiveStartDate;
            }

            public String getEffectiveEndDate() {
                return effectiveEndDate;
            }

            public void setEffectiveEndDate(String effectiveEndDate) {
                this.effectiveEndDate = effectiveEndDate;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getValueAsOf() {
                return valueAsOf;
            }

            public void setValueAsOf(String valueAsOf) {
                this.valueAsOf = valueAsOf;
            }

            public String getTypeCode() {
                return typeCode;
            }

            public void setTypeCode(String typeCode) {
                this.typeCode = typeCode;
            }

            public String getDisclaimer() {
                return disclaimer;
            }

            public void setDisclaimer(String disclaimer) {
                this.disclaimer = disclaimer;
            }

            public String getPromoCode() {
                return promoCode;
            }

            public void setPromoCode(String promoCode) {
                this.promoCode = promoCode;
            }

            public boolean isShareable() {
                return shareable;
            }

            public void setShareable(boolean shareable) {
                this.shareable = shareable;
            }

            public boolean isGiftable() {
                return giftable;
            }

            public void setGiftable(boolean giftable) {
                this.giftable = giftable;
            }

            public String getNotifications() {
                return notifications;
            }

            public void setNotifications(String notifications) {
                this.notifications = notifications;
            }

            public String getValueApplied() {
                return valueApplied;
            }

            public void setValueApplied(String valueApplied) {
                this.valueApplied = valueApplied;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }

            private String description;

            private String effectiveStartDate;

            private String effectiveEndDate;

            private String value;

            private String valueAsOf;

            private String typeCode;

            private String disclaimer;

            private String promoCode;

            private boolean shareable;

            private boolean giftable;

            private String notifications;

            private String valueApplied;

            private boolean deleted;

        }

        public List<AppliedKohlsCash> getAppliedKohlsCash() {
            return appliedKohlsCash;
        }

        public void setAppliedKohlsCash(List<AppliedKohlsCash> appliedKohlsCash) {
            this.appliedKohlsCash = appliedKohlsCash;
        }
    }

}
