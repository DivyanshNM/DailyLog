package com.DailyLog.retrieval.AIChatMessage;

import com.DailyLog.retrieval.DTOs.ChatMsgHistoryDto;
import com.DailyLog.retrieval.User.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public List<ChatMsgHistoryDto> getChatHistory(UserEntity user) {
        List<ChatMessageEntity>  list = chatMessageRepository
                .findByUserEntityIdOrderByCreatedAtAsc(user.getId());

        List<ChatMsgHistoryDto> res=new ArrayList<>();
        for(ChatMessageEntity it: list){
            ChatMsgHistoryDto temp=new ChatMsgHistoryDto();
            temp.setContent(it.getContent());
            temp.setCreatedAt(it.getCreatedAt());
            temp.setId(it.getId());
            temp.setRole(it.getRole());
            res.add(temp);
        }
        return res;
    }
}
