package com.sula.ranjith_learners.dto;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonDTO {

    Map<String,String> stringMap=new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> getStringMap() {
        return stringMap;
    }

    @JsonAnySetter
    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }
}
