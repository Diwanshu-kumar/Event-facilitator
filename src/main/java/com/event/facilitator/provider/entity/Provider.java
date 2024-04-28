package com.event.facilitator.provider.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Provider")
public class Provider {
    @Id
    @Column(name = "provider_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int providerId;

    @Column(name = "provider_name", length = 255)
    private String providerName;

    @Column(name = "email",unique = true,nullable = false, length = 255)
    private String email;

    @Column(name = "mobile_number",length = 20)
    private String mobileNumber;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "password",length = 255)
    private String password;

    public Provider() {
    }

    public Provider(int providerId, String providerName, String email, String mobileNumber, String gender, String password) {
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

