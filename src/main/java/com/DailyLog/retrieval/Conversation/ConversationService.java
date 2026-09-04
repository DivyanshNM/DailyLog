package com.DailyLog.retrieval.Conversation;

import com.DailyLog.retrieval.DTOs.ConvoDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    public boolean addConvo(@Valid ConvoDto convoDto){
        ConversationEntity conversationEntity=new ConversationEntity();
        conversationEntity.setContent(convoDto.getContent());

        return true;
    }
}
