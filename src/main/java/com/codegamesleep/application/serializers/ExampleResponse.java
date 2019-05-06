package com.codegamesleep.application.serializers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExampleResponse {
    private String status;

    public ExampleResponse() {
    }

    @JsonCreator
    public ExampleResponse(@JsonProperty("status") String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
