package com.intalio.victors.model.exercise;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class StudentDTO {

    private Long id;

    @NotNull
    @Size(max = 128)
    private String name;

    @NotNull
    private Integer age;

}
