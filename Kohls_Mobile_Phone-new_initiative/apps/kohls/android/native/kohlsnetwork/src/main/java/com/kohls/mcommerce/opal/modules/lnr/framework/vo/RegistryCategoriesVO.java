package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.util.ArrayList;
import java.util.List;

public class RegistryCategoriesVO implements IValueObject{

    @Expose
    private Long responseCode;
    @Expose
    private String responseMessage;
    @Expose
    private ArrayList<Entries> entries = new ArrayList<Entries>();
    @Expose
    private Object campaignProperties;
    @Expose
    private Object upcProperties;
    @Expose
    private Object entryStats;
    @Expose
    private List<Long> totalEntries = new ArrayList<Long>();
    @Expose
    private String poolName;
    @Expose
    private Object formattedEntryProps;

    /**
     *
     * @return
     * The responseCode
     */
    public Long getResponseCode() {
        return responseCode;
    }

    /**
     *
     * @param responseCode
     * The responseCode
     */
    public void setResponseCode(Long responseCode) {
        this.responseCode = responseCode;
    }

    /**
     *
     * @return
     * The responseMessage
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     *
     * @param responseMessage
     * The responseMessage
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    /**
     *
     * @return
     * The entries
     */
    public ArrayList<Entries> getEntries() {
        return entries;
    }

    /**
     *
     * @param entries
     * The entries
     */
    public void setEntries(ArrayList<Entries> entries) {
        this.entries = entries;
    }

    /**
     *
     * @return
     * The campaignProperties
     */
    public Object getCampaignProperties() {
        return campaignProperties;
    }

    /**
     *
     * @param campaignProperties
     * The campaignProperties
     */
    public void setCampaignProperties(Object campaignProperties) {
        this.campaignProperties = campaignProperties;
    }

    /**
     *
     * @return
     * The upcProperties
     */
    public Object getUpcProperties() {
        return upcProperties;
    }

    /**
     *
     * @param upcProperties
     * The upcProperties
     */
    public void setUpcProperties(Object upcProperties) {
        this.upcProperties = upcProperties;
    }

    /**
     *
     * @return
     * The entryStats
     */
    public Object getEntryStats() {
        return entryStats;
    }

    /**
     *
     * @param entryStats
     * The entryStats
     */
    public void setEntryStats(Object entryStats) {
        this.entryStats = entryStats;
    }

    /**
     *
     * @return
     * The totalEntries
     */
    public List<Long> getTotalEntries() {
        return totalEntries;
    }

    /**
     *
     * @param totalEntries
     * The totalEntries
     */
    public void setTotalEntries(List<Long> totalEntries) {
        this.totalEntries = totalEntries;
    }

    /**
     *
     * @return
     * The poolName
     */
    public String getPoolName() {
        return poolName;
    }

    /**
     *
     * @param poolName
     * The poolName
     */
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    /**
     *
     * @return
     * The formattedEntryProps
     */
    public Object getFormattedEntryProps() {
        return formattedEntryProps;
    }

    /**
     *
     * @param formattedEntryProps
     * The formattedEntryProps
     */
    public void setFormattedEntryProps(Object formattedEntryProps) {
        this.formattedEntryProps = formattedEntryProps;
    }

}

