package com.DailyLog.retrieval.AIChatMessage;

import com.DailyLog.retrieval.User.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public void saveMessage(UserEntity user, String role, String content){
        ChatMessageEntity chatMessageEntity=new ChatMessageEntity();
        chatMessageEntity.setContent(content);
        chatMessageEntity.setRole(role);
        chatMessageEntity.setUserEntity(user);
        chatMessageEntity.setCreatedAt(LocalDateTime.now());

        chatMessageRepository.save(chatMessageEntity);
    }
}
