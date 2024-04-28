package com.event.facilitator.provider.Dto;

public class ProviderDTO {

    private int providerId;

    private String providerName;

    private String email;

    private String mobileNumber;

    private String gender;
    private String password;

    public ProviderDTO() {
    }

    public ProviderDTO(int providerId, String providerName, String email, String mobileNumber, String gender, String password) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
