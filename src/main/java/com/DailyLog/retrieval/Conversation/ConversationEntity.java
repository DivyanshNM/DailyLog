package com.DailyLog.retrieval.Conversation;

import com.DailyLog.retrieval.User.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "conversations")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConversationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDateTime createdAt;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
}
