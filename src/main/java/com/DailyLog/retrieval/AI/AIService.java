package com.DailyLog.retrieval.AI;

import com.DailyLog.retrieval.DTOs.AIResponseDto;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
@Service
public class AIService {

    private final OllamaChatModel model;

    public AIService(@Value("${ai.ollama.base-url}") String baseUrl,
                     @Value("${ai.ollama.model-name}") String modelName
                     ) {
        this.model = OllamaChatModel.builder()
                .baseUrl(baseUrl)
                .modelName(modelName)
                .build();
    }

    public AIResponseDto chat(String message) {
        String res=model.chat(message);
        return new AIResponseDto(res);
    }
}