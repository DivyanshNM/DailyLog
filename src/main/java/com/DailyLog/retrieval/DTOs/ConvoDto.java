package com.DailyLog.retrieval.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConvoDto {
    private Long id;
    private LocalDateTime createdAt;
    @NotBlank
    private String content;
}
