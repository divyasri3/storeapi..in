package com.test.pet.pojo.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Category {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
}
