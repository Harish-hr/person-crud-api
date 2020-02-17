package com.person.personcrudapi.beans;

import lombok.Builder;
import lombok.Data;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Data
@EnableSwagger2
@Builder
public class Hobbies {
    private String hobby;
}
