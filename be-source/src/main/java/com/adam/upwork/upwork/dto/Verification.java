package com.adam.upwork.upwork.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by SadiqAli on 12/9/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Verification {

    @JsonProperty("verified")
    private String verified;

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }
}
