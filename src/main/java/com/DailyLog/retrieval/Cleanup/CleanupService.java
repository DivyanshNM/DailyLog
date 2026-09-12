package com.DailyLog.retrieval.Cleanup;

import com.DailyLog.retrieval.AIChatMessage.ChatMessageEntity;
import com.DailyLog.retrieval.AIChatMessage.ChatMessageRepository;
import com.DailyLog.retrieval.Conversation.ConversationEntity;
import com.DailyLog.retrieval.Conversation.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CleanupService {

    private final ChatMessageRepository chatMessageRepository;
    private final ConversationRepository conversationRepository;

    @Scheduled(cron = "0 0 2 * * *")
    public void deleteOldData() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);

        List<ChatMessageEntity> oldMessages =
                chatMessageRepository.findByCreatedAtBefore(sevenDaysAgo);
        chatMessageRepository.deleteAll(oldMessages);

        List<ConversationEntity> oldConversations =
                conversationRepository.findByCreatedAtBefore(sevenDaysAgo);
        conversationRepository.deleteAll(oldConversations);
    }
}
