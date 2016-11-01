package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.io.Serializable;
import java.util.List;

public class ListReminderNotificationVO implements IValueObject {

    @Expose
    private int responseCode;

    @Expose
    private String responseMessage;

    @Expose
    private List<Notification> notifications;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }


    public class Notification implements Serializable {

        private static final long serialVersionUID = 2L;

        @Expose
        private long notificationId;

        @Expose
        private String listId;

        @Expose
        private String mode;

        @Expose
        private String event;

        @Expose
        private String timeToFire;

        @Expose
        private String enabled;

        @Expose
        private String lastSent;

        public long getNotificationId() {
            return notificationId;
        }

        public void setNotificationId(long notificationId) {
            this.notificationId = notificationId;
        }

        public String getListId() {
            return listId;
        }

        public void setListId(String listId) {
            this.listId = listId;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }



        public String getTimeToFire() {
            return timeToFire;
        }

        public void setTimeToFire(String timeToFire) {
            this.timeToFire = timeToFire;
        }

        public String getEnabled() {
            return enabled;
        }

        public void setEnabled(String enabled) {
            this.enabled = enabled;
        }
    }

}
