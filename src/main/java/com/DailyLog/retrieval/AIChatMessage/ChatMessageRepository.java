package com.DailyLog.retrieval.AIChatMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long > {
    List<ChatMessageEntity> findByCreatedAtBefore(LocalDateTime time);
}
