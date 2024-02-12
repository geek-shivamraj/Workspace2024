package com.srvcode.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties("field_no1")
public class StaticBean {

    @JsonProperty("field_no1")
    private String field1;

    @JsonIgnore
    @JsonProperty("field_no2")
    private String field2;

    @JsonProperty("field_no3")
    private String field3;

    public StaticBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}
