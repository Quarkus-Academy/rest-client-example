package com.ibm.quarkus.academy.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(
        String name,
        String surname,
        String id,
        LocalDate birthDate) {
}
