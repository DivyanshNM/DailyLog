package com.DailyLog.retrieval.AI;

import com.DailyLog.retrieval.AIChatMessage.ChatMessageService;
import com.DailyLog.retrieval.DTOs.AIResponseDto;
import com.DailyLog.retrieval.User.UserEntity;
import com.DailyLog.retrieval.User.UserService;
import dev.langchain4j.model.ollama.OllamaChatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class AIService {

    private final OllamaChatModel model;
    private final UserService userService;
    private final ChatMessageService chatMessageService;

    public AIService(@Value("${ai.ollama.base-url}") String baseUrl,
                     @Value("${ai.ollama.model-name}") String modelName, UserService userService, ChatMessageService chatMessageService
    ) {
        this.userService = userService;
        this.chatMessageService = chatMessageService;
        this.model = OllamaChatModel.builder()
                .baseUrl(baseUrl)
                .modelName(modelName)
                .build();
    }

    public AIResponseDto chat(String message) {
        UserEntity user=userService.getCurrentUser();
        chatMessageService.saveMessage(user,"USER",message);
        String res=model.chat(message);
        chatMessageService.saveMessage(user,"AI",res);
        return new AIResponseDto(res);
    }
}