package com.DailyLog.retrieval.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Size(min=8)
    private String password;
}
