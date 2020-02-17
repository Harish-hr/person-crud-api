package com.person.personcrudapi.beans;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PersonDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String favouriteColor;
    private List<String> hobby;
}
