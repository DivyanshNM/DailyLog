package com.DailyLog.retrieval.Conversation;

import com.DailyLog.retrieval.DTOs.ConvoDto;
import com.DailyLog.retrieval.DTOs.ConvoResponse;
import com.DailyLog.retrieval.User.UserEntity;
import com.DailyLog.retrieval.User.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;
    @Autowired
    private UserService userService;

    public boolean addConvo(ConvoDto convoDto){
        UserEntity user=userService.getCurrentUser();
        ConversationEntity conversationEntity=new ConversationEntity();
        conversationEntity.setContent(convoDto.getContent());
        conversationEntity.setUser(user);
        conversationRepository.save(conversationEntity);
        return true;
    }

    public List<ConvoResponse> getMyConversation(){
        UserEntity user=userService.getCurrentUser();
        List<ConversationEntity> list=conversationRepository.findByUserId(user.getId());
        List<ConvoResponse> ans=new ArrayList<>();
        for(ConversationEntity it:list){
            ConvoResponse temp=new ConvoResponse();
            temp.setContent(it.getContent());
            temp.setCreatedAt(it.getCreatedAt());
            temp.setId(it.getId());
            ans.add(temp);
        }
        return ans;
    }

    public Optional<ConvoResponse> findById(Long id) {
        Optional<ConversationEntity> conversationEntity=conversationRepository.findById(id);
        if(conversationEntity.isPresent()){
            ConvoResponse convoResponse=new ConvoResponse();
            convoResponse.setCreatedAt(conversationEntity.get().getCreatedAt());
            convoResponse.setId(conversationEntity.get().getId());
            convoResponse.setContent(conversationEntity.get().getContent());
            return Optional.of(convoResponse);
        }
        return Optional.empty();
    }
    public boolean deleteById(Long id){
        boolean exists=conversationRepository.exitsById(id);
        if(exists){
            conversationRepository.deleteById(id);
            return true;
        }else return false;
    }
}
