package com.adam.upwork.upwork.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by SadiqAli on 12/9/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommitDTO {

    @JsonProperty("sha")
    private String sha;

    @JsonProperty("commit")
    private Commit commit;



    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }
}
