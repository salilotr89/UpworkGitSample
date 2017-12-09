package com.adam.upwork.upwork.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by SadiqAli on 12/9/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Committer {

    @JsonProperty("name")
    private String name;

    @JsonProperty("date")
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
