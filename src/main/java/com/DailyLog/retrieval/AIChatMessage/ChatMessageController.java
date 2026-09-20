package com.DailyLog.retrieval.AIChatMessage;

import com.DailyLog.retrieval.DTOs.ChatMsgHistoryDto;
import com.DailyLog.retrieval.User.UserEntity;
import com.DailyLog.retrieval.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai/history")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<ChatMsgHistoryDto>> getHistory(){
        UserEntity user=userService.getCurrentUser();
        List<ChatMsgHistoryDto> list= chatMessageService.getChatHistory(user);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
