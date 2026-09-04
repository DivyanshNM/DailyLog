package com.DailyLog.retrieval.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUserDto {
    private String name;
    private String email;
    public ResponseUserDto(CreateUserDto userDto){
        this.name=userDto.getName();
        this.email=userDto.getEmail();
    }
}
