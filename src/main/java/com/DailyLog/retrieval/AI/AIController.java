package com.DailyLog.retrieval.AI;

import com.DailyLog.retrieval.DTOs.AIResponseDto;
import com.DailyLog.retrieval.DTOs.PromptDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIController {
    private final AIService aiService;

    @PostMapping("/chat")
    public AIResponseDto chat(@RequestBody PromptDto promptDto){
        return aiService.chat(promptDto.getMessage());
    }

}
