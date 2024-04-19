package com.company.lc_managment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterDTO(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotNull LocalDate birthday,
        @NotBlank String phoneNumber,
        @NotBlank String password,
        @NotBlank String gender,
        @NotBlank String department,
        Integer attachmentId) {
}
