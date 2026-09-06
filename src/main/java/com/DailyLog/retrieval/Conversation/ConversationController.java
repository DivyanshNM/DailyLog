package com.DailyLog.retrieval.Conversation;


import com.DailyLog.retrieval.DTOs.ConvoDto;
import com.DailyLog.retrieval.DTOs.ConvoResponse;
import com.DailyLog.retrieval.User.UserEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @PostMapping("/addConvo")
    public ResponseEntity<Boolean> addConvo(@Valid @RequestBody ConvoDto convoDto){
        boolean done= conversationService.addConvo(convoDto);
        if(done){
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }else return new ResponseEntity<>(Boolean.FALSE,HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ConvoResponse>> getConvo(){
        List<ConvoResponse> conversations=conversationService.getMyConversation();
        return new ResponseEntity<>(conversations,HttpStatus.OK);
    }
}
