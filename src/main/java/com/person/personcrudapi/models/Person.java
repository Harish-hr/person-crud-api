package com.person.personcrudapi.models;

import javax.persistence.*;
import java.util.List;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs(@TypeDef(name = "string-array", typeClass = StringArrayType.class))
@Table(name = "PERSONS")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "FAVOURITE_COLOR")
    private String favouriteColor;

    @ElementCollection // 1
    @CollectionTable(name = "MY_HOBBY", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "HOBBY") // 3
    private List<String> hobby;

}
