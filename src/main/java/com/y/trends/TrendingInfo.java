package com.y.trends;

/**
 * Created with IntelliJ IDEA.
 * User: ashwath
 * Date: 11/14/13
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrendingInfo {
    private String locationRating;
    private String locationReviewCount;
    private String locationName;
    private String locationCity;
    private String phone;
    private String snippettext;
    private String addressdetails;

    public TrendingInfo() {

    }

    public TrendingInfo(String locationName, String addressdetails, String locationCity, String locationRating, String locationReviewCount, String phone, String snippettext) {
        this.locationRating = locationRating;
        this.locationReviewCount = locationReviewCount;
        this.locationName = locationName;
        this.locationCity = locationCity;
        this.phone = phone;
        this.snippettext = snippettext;
        this.addressdetails = addressdetails;
    }

    public String getAddressdetails() {
        return addressdetails;
    }

    public void setAddressdetails(String addressdetails) {
        this.addressdetails = addressdetails;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSnippettext() {
        return snippettext;
    }

    public void setSnippettext(String snippettext) {
        this.snippettext = snippettext;
    }

    public String getLocationRating() {
        return locationRating;
    }

    public void setLocationRating(String locationRating) {
        this.locationRating = locationRating;
    }

    public String getLocationReviewCount() {
        return locationReviewCount;
    }

    public void setLocationReviewCount(String locationReviewCount) {
        this.locationReviewCount = locationReviewCount;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }
}
