package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.common.util.NetworkUtils;
import com.kohls.mcommerce.opal.framework.view.fragment.productdetails.iface.QuantityViewState;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class StoreLocatorVO implements IValueObject {

    private static final long serialVersionUID = 1L;

    @Expose
    private List<ErrorVO> errors;

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
    }

    @Expose
    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload implements Serializable {

        private static final long serialVersionUID = 9L;

        @Expose
        private List<Store> stores;

        public List<Store> getStores() {
            return stores;
        }

        public void setStores(List<Store> stores) {
            this.stores = stores;
        }

        public class Store implements Serializable, QuantityViewState {
            private static final long serialVersionUID = 10L;

            @Expose
            private String storeNum;

            @Expose
            private String storeName;

            @Expose
            private String channel;

            @Expose
            private String availability;

            @Expose
            private String availableStock;

            @Expose
            private String allocatedStock;

            private int mSelectedQty;

            @Expose
            private boolean isBopusEligibleStore;

            @Expose
            private boolean isBopusEligible;

            public boolean isBopusEligibleStore() {
                return isBopusEligibleStore;
            }

            public void setBopusEligibleStore(boolean isBopusEligibleStore) {
                this.isBopusEligibleStore = isBopusEligibleStore;
            }

            public boolean isBopusEligible() {
                return isBopusEligible;
            }

            public void setBopusEligible(boolean isBopusEligible) {
                this.isBopusEligible = isBopusEligible;
            }

            public String getAllocatedStock() {
                return allocatedStock;
            }

            public void setAllocatedStock(String allocatedStock) {
                this.allocatedStock = allocatedStock;
            }

            public String getAvailableStock() {
                return availableStock;
            }

            public void setAvailableStock(String availableStock) {
                this.availableStock = availableStock;
            }

            public String getAvailability() {
                return availability;
            }

            public void setAvailability(String availability) {
                this.availability = availability;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getStoreNum() {
                return storeNum;
            }

            public void setStoreNum(String storeNum) {
                this.storeNum = storeNum;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            private String errorMess;

            public String getErrorMess() {
                return errorMess;
            }

            public void setErrorMess(String errorMess) {
                this.errorMess = errorMess;
            }

            @Expose
            private StoreHour storeHours;

            public StoreHour getStoreHours() {
                return storeHours;
            }

            public void setStoreHours(StoreHour storeHours) {
                this.storeHours = storeHours;
            }

            public class StoreHour implements Serializable {
                private static final long serialVersionUID = 11L;

                @Expose
                private List<Day> days;

                public List<Day> getDays() {
                    return days;
                }

                public void setDays(List<Day> days) {
                    this.days = days;
                }

                private HashMap<String, String> operationHours;

                public HashMap<String, String> getHoursOfOperation() {
                    return operationHours;
                }

                public void setHoursofOperation() {

                    operationHours = new HashMap<String, String>();
                    for (int i = 0; i < getDays().size(); i++) {
                        Day currDay = getDays().get(i);
                        if (currDay != null && NetworkUtils.getShortDayName(currDay.getDayName()) != null) {
                            StringBuilder hoursofOper = new StringBuilder();
                            operationHours.put(currDay.getDayName().toLowerCase(),
                                    (hoursofOper.append(" ")
                                            .append(currDay.getHoursofOperation().getOpenTimes())
                                            .append(" - ")
                                            .append(currDay.getHoursofOperation().getCloseTimes()).toString()));
                        }
                    }

                }

                public class Day implements Serializable {

                    private static final long serialVersionUID = 20L;

                    @Expose
                    private String name;

                    public String getDayName() {
                        return name;
                    }

                    public void setDayName(String name) {
                        this.name = name;
                    }

                    @Expose
                    private Hour hours;

                    public Hour getHoursofOperation() {
                        return hours;
                    }

                    public void setHoursofOperation(Hour hours) {
                        this.hours = hours;
                    }

                    public class Hour implements Serializable {

                        private static final long serialVersionUID = 5L;

                        @Expose
                        private String open;

                        public void setOpenTimes(String open) {
                            this.open = open;
                        }

                        public String getOpenTimes() {
                            return open;
                        }

                        @Expose
                        private String close;

                        public void setCloseTimes(String close) {
                            this.close = close;
                        }

                        public String getCloseTimes() {
                            return close;
                        }

                    }

                }

            }

            @Expose
            private Address address;

            public Address getAddress() {
                return address;
            }

            public void setAddress(Address address) {
                this.address = address;
            }

            public class Address implements Serializable {
                private static final long serialVersionUID = 15L;

                @Expose
                private String addr1;

                public void setAddr1(String addr1) {
                    this.addr1 = addr1;
                }

                public String getAddr1() {
                    return addr1;
                }

                @Expose
                private String addr2;

                public void setAddr2(String addr2) {
                    this.addr2 = addr2;
                }

                public String getAddr2() {
                    return addr2;
                }

                @Expose
                private String city;

                public void setCity(String city) {
                    this.city = city;
                }

                public String getCity() {
                    return city;
                }

                @Expose
                private Location location;

                public Location getLocation() {
                    return location;
                }

                public void setLocation(Location location) {
                    this.location = location;
                }

                public class Location implements Serializable {
                    private static final long serialVersionUID = 16L;

                    @Expose
                    private String longitude;

                    public void setLongitude(String longitude) {
                        this.longitude = longitude;
                    }

                    public double getLongitude() {
                        return Double.parseDouble(longitude);
                    }

                    @Expose
                    private String latitude;

                    public void setLatitude(String latitude) {
                        this.latitude = latitude;
                    }

                    public double getLatitude() {
                        return Double.parseDouble(latitude);
                    }

                }

                @Expose
                private String state;

                public void setState(String state) {
                    this.state = state;
                }

                public String getState() {
                    return state;
                }

                @Expose
                private String postalCode;

                public void setPostalCode(String postalCode) {
                    this.postalCode = postalCode;
                }

                public String getPostalCode() {
                    return postalCode;
                }

            }

            @Expose
            private ContactInfo[] contactInfo;

            public ContactInfo[] getContactInfo() {
                return contactInfo;
            }

            public void setContactInfo(ContactInfo[] contactInfo) {
                this.contactInfo = contactInfo;
            }

            public class ContactInfo implements Serializable {

                private static final long serialVersionUID = 12L;

                @Expose
                private String value;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                @Expose
                private String type;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

            }

            @Expose
            private String distanceFromOrigin;

            public void setDistanceFromOrigin(String distanceFromOrigin) {
                this.distanceFromOrigin = distanceFromOrigin;
            }

            public String getDistanceFromOrigin() {
                return distanceFromOrigin;
            }

            @Override
            public void setProductQty(int qty) {
                if (qty < 1) {
                    mSelectedQty = 1;
                } else {
                    mSelectedQty = qty;
                }
            }

            @Override
            public int getProductQty() {
                if (mSelectedQty < 1) {
                    mSelectedQty = 1;
                }
                return mSelectedQty;
            }
        }
    }
}
