package com.DailyLog.retrieval.Conversation;


import com.DailyLog.retrieval.DTOs.ConvoDto;
import com.DailyLog.retrieval.DTOs.ConvoResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<ConvoResponse> getConvoById(@PathVariable Long id){
        Optional<ConvoResponse> convoResponse=conversationService.findById(id);
        if(convoResponse.isPresent()){
            return new ResponseEntity<>(convoResponse.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        boolean deleted=conversationService.deleteById(id);
        if(deleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
