package com.gigya.android.sdk.model.profile;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OidcData {

    @Nullable
    private List<Address> addresses;
    @Nullable
    @SerializedName("email_verified")
    private String emailVerified;
    @Nullable
    private String locale;
    @Nullable
    private String middle_name;
    @Nullable
    private String name;
    @Nullable
    private String phone_number;
    @Nullable
    @SerializedName("phone_number_verified")
    private String phoneNumberVerified;
    @Nullable
    private String updated_at;
    @Nullable
    private String website;
    @Nullable
    private String zoneinfo;

    @Nullable
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(@Nullable List<Address> addresses) {
        this.addresses = addresses;
    }

    @Nullable
    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(@Nullable String emailVerified) {
        this.emailVerified = emailVerified;
    }

    @Nullable
    public String getLocale() {
        return locale;
    }

    public void setLocale(@Nullable String locale) {
        this.locale = locale;
    }

    @Nullable
    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(@Nullable String middle_name) {
        this.middle_name = middle_name;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(@Nullable String phone_number) {
        this.phone_number = phone_number;
    }

    @Nullable
    public String getPhoneNumberVerified() {
        return phoneNumberVerified;
    }

    public void setPhoneNumberVerified(@Nullable String phoneNumberVerified) {
        this.phoneNumberVerified = phoneNumberVerified;
    }

    @Nullable
    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(@Nullable String updated_at) {
        this.updated_at = updated_at;
    }

    @Nullable
    public String getWebsite() {
        return website;
    }

    public void setWebsite(@Nullable String website) {
        this.website = website;
    }

    @Nullable
    public String getZoneinfo() {
        return zoneinfo;
    }

    public void setZoneinfo(@Nullable String zoneinfo) {
        this.zoneinfo = zoneinfo;
    }
}