package com.restassured.deserialization.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserList {

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("job")
    public String getJob() {
        return job;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}