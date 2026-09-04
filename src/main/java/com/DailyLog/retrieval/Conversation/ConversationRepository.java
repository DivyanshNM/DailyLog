package com.DailyLog.retrieval.Conversation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<ConversationEntity,Long> {
    List<ConversationEntity> findByUserId(Long userId);

}
