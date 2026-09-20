package com.DailyLog.retrieval.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMsgHistoryDto {
    private Long id;
    private String role;
    private String content;
    private LocalDateTime createdAt;
}
