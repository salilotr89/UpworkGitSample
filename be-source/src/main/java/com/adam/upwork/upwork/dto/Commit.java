package com.adam.upwork.upwork.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by SadiqAli on 12/9/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {

    @JsonProperty("committer")
    private Committer committer;

    @JsonProperty("verification")
    private Verification verification;

    @JsonProperty("message")
    private String message;


    public Committer getCommitter() {
        return committer;
    }

    public void setCommitter(Committer committer) {
        this.committer = committer;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
