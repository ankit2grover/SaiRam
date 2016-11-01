package com.kohls.mcommerce.opal.helper.adapter.rest.config;

/**
 * @author neeraj.kumar@kohls.com
 *
 */
public class ServicesConfig {

    private Projects[] projects;

    private String platformVersion;

    private String deployTime;

    private Urls[] urls;

    private String description;

    private String connectivityDetails;

    private String link;

    private String name;

    private String resourceHash;

    private String productVersion;

    private String[] procedures;

    public Projects[] getProjects() {
        return projects;
    }

    public void setProjects(Projects[] projects) {
        this.projects = projects;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(String deployTime) {
        this.deployTime = deployTime;
    }

    public Urls[] getUrls() {
        return urls;
    }

    public void setUrls(Urls[] urls) {
        this.urls = urls;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConnectivityDetails() {
        return connectivityDetails;
    }

    public void setConnectivityDetails(String connectivityDetails) {
        this.connectivityDetails = connectivityDetails;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceHash() {
        return resourceHash;
    }

    public void setResourceHash(String resourceHash) {
        this.resourceHash = resourceHash;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String[] getProcedures() {
        return procedures;
    }

    public void setProcedures(String[] procedures) {
        this.procedures = procedures;
    }

    @Override
    public String toString() {
        return "ServicesConfig [projects = " + projects + ", platformVersion = " + platformVersion + ", deployTime = " + deployTime + ", urls = " + urls + ", description = " + description + ", connectivityDetails = " + connectivityDetails + ", link = " + link + ", name = " + name + ", resourceHash = " + resourceHash + ", productVersion = " + productVersion + ", procedures = " + procedures + "]";
    }
}