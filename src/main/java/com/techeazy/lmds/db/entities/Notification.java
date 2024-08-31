package com.techeazy.lmds.db.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "message_type", nullable = false)
    private String messageType; // SMS, Email

    @Column(name = "message_content", nullable = false)
    private String messageContent;

    @Column(name = "sent_time", nullable = false)
    private LocalDateTime sentTime;

    @Column(nullable = false)
    private String status;
}
